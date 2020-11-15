package minesweeper.controller;

import central.util.guice.PersistenceModule;
import com.gluonhq.ignite.guice.GuiceContext;
import com.google.inject.AbstractModule;
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

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;


@Slf4j
public class LaunchController {

    private FXMLLoader fxmlLoader = new FXMLLoader();

    @FXML
    private TextField playerNameTextField;

    @FXML
    private Label errorLabel;

    @FXML
    public void initialize() {
    }

    public void startAction(ActionEvent actionEvent) throws IOException {
        if (playerNameTextField.getText().isEmpty()) {
            errorLabel.setText("Enter your name!");
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
