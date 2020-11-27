package puckg.controller;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import puckg.data.GameDataDao;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

public class StartController {

    private GuiceContext context = new GuiceContext(this, () -> List.of(
            new AbstractModule() {
                @Override
                protected void configure() {
                    install(new PersistenceModule("puckgame"));
                    bind(GameDataDao.class);
                }
            }
    ));

    @Inject
    private FXMLLoader fxmlLoader;

    @FXML
    private JFXTextField player1NameTextField;

    @FXML
    private JFXTextField player2NameTextField;

    @FXML
    public void initialize() {
        context.init();

        RequiredFieldValidator player1Validator = new RequiredFieldValidator();
        player1Validator.setMessage("Input Required");
        RequiredFieldValidator player2Validator = new RequiredFieldValidator();
        player2Validator.setMessage("Input Required");


        player1NameTextField.getValidators().add(player1Validator);
        player2NameTextField.getValidators().add(player2Validator);

        player1NameTextField.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) player1NameTextField.validate();
        });

        player2NameTextField.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) player2NameTextField.validate();
        });
    }

    public void startAction(ActionEvent actionEvent) throws IOException {
        if (!player1NameTextField.validate() || !player2NameTextField.validate()) {
            return;
        }
        fxmlLoader.setLocation(getClass().getResource("/fxml/puckg/game.fxml"));
        Parent root = fxmlLoader.load();
        fxmlLoader.<GameController>getController().setPlayer1Name(player1NameTextField.getText());
        fxmlLoader.<GameController>getController().setPlayer2Name(player2NameTextField.getText());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
