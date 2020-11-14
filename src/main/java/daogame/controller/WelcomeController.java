package daogame.controller;

import central.util.guice.PersistenceModule;
import com.gluonhq.ignite.guice.GuiceContext;
import com.google.inject.AbstractModule;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
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

}
