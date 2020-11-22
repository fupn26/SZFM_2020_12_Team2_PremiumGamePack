package daogame.controller;

import central.util.guice.PersistenceModule;
import com.gluonhq.ignite.guice.GuiceContext;
import com.google.inject.AbstractModule;
import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import daogame.data.GameResultDao;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@Slf4j
public class WelcomeController {

    private final GuiceContext context = new GuiceContext(this, () -> List.of(
            new AbstractModule() {
                @Override
                protected void configure() {
                    install(new PersistenceModule("dao"));
                    bind(GameResultDao.class);
                }
            }
    ));

    @Inject
    private FXMLLoader fxmlLoader;

    @FXML
    private JFXTextField player1Input;

    @FXML
    private JFXTextField player2Input;

    @FXML
    public void initialize() {
        context.init();

        RequiredFieldValidator player1Validator = new RequiredFieldValidator();
        player1Validator.setMessage("Input Required");
        RequiredFieldValidator player2Validator = new RequiredFieldValidator();
        player2Validator.setMessage("Input Required");


        player1Input.getValidators().add(player1Validator);
        player2Input.getValidators().add(player2Validator);

        player1Input.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) player1Input.validate();
        });

        player2Input.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) player2Input.validate();
        });

    }

    public void onStartGameButtonClicked(MouseEvent mouseEvent) throws IOException {
        if (!player1Input.validate() || !player2Input.validate()) {
            return;
        }
        String player1Name = player1Input.getText();
        String player2Name = player2Input.getText();
        fxmlLoader.setLocation(getClass().getResource("/fxml/daogame/game.fxml"));
        Parent root = fxmlLoader.load();
        fxmlLoader.<daogame.controller.GameController>getController().setPlayerNames(player1Name,
                player2Name);
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
