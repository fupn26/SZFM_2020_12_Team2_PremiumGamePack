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

    private void resetGame(){
        gameState = new MsweeperState(5,10,10);
        startTime = Instant.now();
        gameOver.setValue(false);
        displayGameState();
        createStopWatch();
        Platform.runLater(() -> messageLabel.setText("Good luck, " + playerName + "!"));
        giveUpButton.setDisable(false);
        resetButton.setText("Reset");
    }

    private void displayGameState(){
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 10; j++){
                ImageView view = (ImageView) gameGrid.getChildren().get(i * 10+ j);
                view.setImage(imageList.get(gameState.displayGrid()[i][j]));
            }
        }
    }

    public void handleClickOnSquare(MouseEvent mouseEvent) {
        int row = GridPane.getRowIndex((Node) mouseEvent.getSource());
        int col = GridPane.getColumnIndex((Node) mouseEvent.getSource());
        log.debug("Square ({}, {}) is pressed", row, col);
        if (! gameState.isWon() && ! gameState.isLost()) {
            while(gameState.isHidden() && gameState.getMinegrid()[row][col]==1) {
                gameState = new MsweeperState(5,10,10);
            }
            if(mouseEvent.getButton() == MouseButton.PRIMARY) gameState.reveal(row,col);
            if(mouseEvent.getButton() == MouseButton.SECONDARY) gameState.putFlag(row,col);
            if (gameState.isLost()) {
                gameOver.setValue(true);
                for(int i=0; i<5; i++){
                    for(int j=0; j<10; j++){
                        if(gameState.getFlaggrid()[i][j] == 1) gameState.putFlag(i,j);
                        gameState.reveal(i,j);
                    }
                }
                displayGameState();
                giveUpButton.setDisable(true);
                resetButton.setText("Retry");
                messageLabel.setText("Game Over. Try again?");
            }
            else if (gameState.isWon()) {
                gameOver.setValue(true);
                log.info("Player {} has solved the game", playerName);
                messageLabel.setText("Congratulations, " + playerName + "!");
                resetButton.setDisable(true);
                giveUpButton.setText("Finish");
            }

        }
        displayGameState();
    }

    public void handleResetButton(ActionEvent actionEvent)  {
        stopwatchTimeline.stop();
        resetGame();
    }

    private void createStopWatch() {
        stopwatchTimeline = new Timeline(new KeyFrame(javafx.util.Duration.ZERO, e -> {
            long millisElapsed = startTime.until(Instant.now(), ChronoUnit.MILLIS);
            stopwatchLabel.setText(DurationFormatUtils.formatDuration(millisElapsed, "HH:mm:ss"));
        }), new KeyFrame(javafx.util.Duration.seconds(1)));
        stopwatchTimeline.setCycleCount(Animation.INDEFINITE);
        stopwatchTimeline.play();
    }
}
