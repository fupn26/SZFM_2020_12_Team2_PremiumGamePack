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

    private Parent dialog;
    private Scene dialogScene;
    private final StringProperty player1Name = new SimpleStringProperty();
    private final StringProperty player2Name = new SimpleStringProperty();
    private boolean isPlayer1NameSet;
    private boolean isPlayer2NameSet;

    public void onStartGameButtonClicked(MouseEvent mouseEvent) throws IOException {
        fxmlLoader.setLocation(getClass().getResource("/fxml/daogame/game.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
        stage.setResizable(true);
        stage.show();
    }
}
