package daogame.controller;

import daogame.state.GameState;
import daogame.state.Position;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.List;

@Slf4j
public class GameController {
    @Inject
    private FXMLLoader fxmlLoader;

    @FXML
    private Label player1Label;

    private final StringProperty player1Name = new SimpleStringProperty();

    @FXML
    private Label player2Label;

    private final StringProperty player2Name = new SimpleStringProperty();

    @FXML
    private Label timeLabel;

    private Timeline stopWatch;

    @FXML
    private GridPane gameGrid;

    @FXML
    private Label blueTurnIndicator;

    @FXML
    private Label redTurnIndicator;

    private GameState gameState;
    private long elapsedTime;
    private List<String> buttonSytles;

    private Position from;
    private Position to;

    private final BooleanProperty gameOver = new SimpleBooleanProperty();

    public void setPlayerNames(String player1Name, String player2Name) {
        this.player1Name.setValue(player1Name);
        this.player2Name.setValue(player2Name);
    }

}
