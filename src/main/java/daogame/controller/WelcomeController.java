package daogame.controller;

import central.util.guice.PersistenceModule;
import com.gluonhq.ignite.guice.GuiceContext;
import com.google.inject.AbstractModule;
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

    @Inject
    private FXMLLoader fxmlLoader;

    @FXML
    private Label warningLabel;

    @FXML
    private TextField player1Input;

    @FXML
    private TextField player2Input;


    public void onStartGameButtonClicked(MouseEvent mouseEvent) throws IOException {
        String player1Name = player1Input.getText();
        String player2Name = player2Input.getText();
        if (player1Name.isEmpty() || player2Name.isEmpty()) {
            warningLabel.setVisible(true);
            return;
        }
        fxmlLoader.setLocation(getClass().getResource("/fxml/daogame/game.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
        stage.setResizable(true);
        stage.show();
    }
}
