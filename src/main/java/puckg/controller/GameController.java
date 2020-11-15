package puckg.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import org.apache.commons.lang3.time.DurationFormatUtils;
import puckg.state.TableState;

import javax.inject.Inject;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class GameController {

    @Inject
    private FXMLLoader fxmlLoader;

    private String[] players = new String[2];
    private int[] points = new int[2];
    private int player;
    private TableState tableState;
    private Instant startTime;
    private List<Image> cellImages;
    private List<Image> cellImagesOnMove;
    private int prevRow = -1;
    private int prevCol = -1;
    private int playerGaveUp = -1;

    @FXML
    private Label infoLabel;

    @FXML
    private Label player1Label;

    @FXML
    private Label player2Label;

    @FXML
    private Label player1PointsLabel;

    @FXML
    private Label player2PointsLabel;

    @FXML
    private GridPane gameGrid;

    @FXML
    private Label stopWatchLabel;

    @FXML
    private Timeline stopWatchTimeLine;

    @FXML
    private Button giveUpButton;

    private BooleanProperty gameOver = new SimpleBooleanProperty();

    public void setPlayer1Name(String player1Name) {
        this.players[0] = player1Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.players[1] = player2Name;
    }

    private void resetGame () {
        tableState = new TableState();
        startTime = Instant.now();
        gameOver.setValue(false);
        createStopWatch();
        Platform.runLater(() -> infoLabel.setText("VS"));
        infoLabel.setPrefWidth(100);
        Platform.runLater(() -> player1Label.setText(players[0]));
        Platform.runLater(() -> player1Label.setStyle("-fx-background-color: darksalmon;"));
        Platform.runLater(() -> player2Label.setText(players[1]));
        player1Label.setVisible(true);
        player2Label.setVisible(true);
        player1PointsLabel.setVisible(true);
        player2PointsLabel.setVisible(true);
        giveUpButton.setText("Give Up");
        player = 1;
        displayGameState();
    }

    private void displayGameState() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                ImageView view = (ImageView) gameGrid.getChildren().get(i * 6 + j);
                view.setImage(cellImages.get(tableState.getTable()[i][j].getValue()));
            }
        }
        calculatePoints();
        player1PointsLabel.setText(Integer.toString(points[0]));
        player2PointsLabel.setText(Integer.toString(points[1]));
        player1Label.setStyle("-fx-background-color: transparent;");
        player2Label.setStyle("-fx-background-color: transparent;");
        player1Label.setText(players[0]);
        player2Label.setText(players[1]);
        if(player == 1) {
            player1Label.setStyle("-fx-background-color: darksalmon;");
        } else {
            player2Label.setStyle("-fx-background-color: dodgerblue;");
        }
    }

    private void createStopWatch () {
        stopWatchTimeLine = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            long millisElapsed = startTime.until(Instant.now(), ChronoUnit.MILLIS);
            stopWatchLabel.setText(DurationFormatUtils.formatDuration(millisElapsed, "HH:mm:ss"));
        }), new KeyFrame(Duration.seconds(1)));
        stopWatchTimeLine.setCycleCount(Animation.INDEFINITE);
        stopWatchTimeLine.play();
    }

    private void calculatePoints () {
        this.points[0] = tableState.pointsOfPlayer(1);
        this.points[1] = tableState.pointsOfPlayer(2);
    }

    private int winner (int playerGaveUp) {
        if(playerGaveUp > 0) {
            return oppositePlayer(playerGaveUp) - 1;
        }
        if(points[0] > points[1]) {
            return 0;
        }
        if (points[1] > points[0]) {
            return 1;
        }
        return oppositePlayer(player) - 1;
    }

    private int oppositePlayer (int player) {
        if(player == 1) {
            return 2;
        } else return 1;
    }
}
