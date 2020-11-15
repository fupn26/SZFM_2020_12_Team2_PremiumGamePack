package minesweeper.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import minesweeper.state.MsweeperState;
import org.apache.commons.lang3.time.DurationFormatUtils;

import javax.inject.Inject;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Slf4j
public class GameController {


    @Inject
    private FXMLLoader fxmlLoader;

    private String playerName;
    private MsweeperState gameState;
    private Instant startTime;
    private List<Image> imageList;

    @FXML
    private Label messageLabel;

    @FXML
    private GridPane gameGrid;

    @FXML
    private Label stopwatchLabel;

    private Timeline stopwatchTimeline;

    @FXML
    private Button resetButton;

    @FXML
    private Button giveUpButton;

    private BooleanProperty gameOver = new SimpleBooleanProperty();

    public void setPlayerName(String playerName) {this.playerName = playerName;}

    @FXML
    public void initialize() {
        imageList = List.of(
                new Image(getClass().getResource("/images/minesweeper/hidden.png").toExternalForm()),
                new Image(getClass().getResource("/images/minesweeper/flagged.png").toExternalForm()),
                new Image(getClass().getResource("/images/minesweeper/bomb.png").toExternalForm()),
                new Image(getClass().getResource("/images/minesweeper/revealed0.png").toExternalForm()),
                new Image(getClass().getResource("/images/minesweeper/revealed1.png").toExternalForm()),
                new Image(getClass().getResource("/images/minesweeper/revealed2.png").toExternalForm()),
                new Image(getClass().getResource("/images/minesweeper/revealed3.png").toExternalForm()),
                new Image(getClass().getResource("/images/minesweeper/revealed4.png").toExternalForm()),
                new Image(getClass().getResource("/images/minesweeper/revealed5.png").toExternalForm()),
                new Image(getClass().getResource("/images/minesweeper/revealed6.png").toExternalForm()),
                new Image(getClass().getResource("/images/minesweeper/revealed7.png").toExternalForm()),
                new Image(getClass().getResource("/images/minesweeper/revealed8.png").toExternalForm())
        );
        gameOver.addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                stopwatchTimeline.stop();
            }
        });
        resetGame();
    }
}
