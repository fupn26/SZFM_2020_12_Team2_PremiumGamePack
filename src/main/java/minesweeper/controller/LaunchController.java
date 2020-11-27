package minesweeper.controller;

import central.util.guice.PersistenceModule;
import com.gluonhq.ignite.guice.GuiceContext;
import com.google.inject.AbstractModule;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import puckg.data.GameDataDao;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@Slf4j
public class LaunchController {

    private GuiceContext context = new GuiceContext(this, () -> List.of(
            new AbstractModule() {
                @Override
                protected void configure() {
                    install(new PersistenceModule("minesweeper"));
                    bind(GameDataDao.class);
                }
            }
    ));

    @Inject
    private FXMLLoader fxmlLoader;

    @FXML
    private JFXTextField playerNameTextField;

    @FXML
    public void initialize() {
        context.init();

        RequiredFieldValidator playerValidator = new RequiredFieldValidator();
        playerValidator.setMessage("Input Required");

        playerNameTextField.getValidators().add(playerValidator);

        playerNameTextField.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) playerNameTextField.validate();
        });
    }

    public void startAction(ActionEvent actionEvent) throws IOException {
        if (!playerNameTextField.validate()) {
            return;
        } else {
            fxmlLoader.setLocation(getClass().getResource("/fxml/minesweeper/game.fxml"));
            Parent root = fxmlLoader.load();
            fxmlLoader.<GameController>getController().setPlayerName(playerNameTextField.getText());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

}