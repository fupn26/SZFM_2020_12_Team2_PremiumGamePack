package daogame.controller;

import daogame.state.GameState;
import daogame.state.Position;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DurationFormatUtils;

import javax.inject.Inject;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GameController {

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

    @FXML
    public void initialize() {

        buttonSytles = new ArrayList<>();
        buttonSytles.add(getClass().getResource("/css/whitebutton.css").toExternalForm());
        buttonSytles.add(getClass().getResource("/css/bluebutton.css").toExternalForm());
        buttonSytles.add(getClass().getResource("/css/redbutton.css").toExternalForm());

        blueTurnIndicator.getStylesheets().add(getClass().getResource("/css/blueindicator.css").toExternalForm());
        redTurnIndicator.getStylesheets().add(getClass().getResource("/css/redindicator.css").toExternalForm());

        gameOver.addListener((observable, oldValue, newValue) -> {
            stopWatch.stop();
        });

        player1Label.textProperty().bind(player1Name);
        player2Label.textProperty().bind(player2Name);

        Platform.runLater(() -> {
            startGame();
        });
    }

    private void startGame() {
        gameState = new GameState();
        elapsedTime = 0;
        gameOver.setValue(false);
        displayGameState();
        setTurnIndicator();
        createStopWatch();
    }

    private void setTurnIndicator() {
        int turn = gameState.getTurnID();
        if (turn == 1){
            redTurnIndicator.setDisable(true);
            blueTurnIndicator.setDisable(false);
        } else {
            redTurnIndicator.setDisable(false);
            blueTurnIndicator.setDisable(true);
        }
    }

    private void createStopWatch() {
        stopWatch = new Timeline(new KeyFrame(javafx.util.Duration.ZERO, e -> {
            timeLabel.setText(DurationFormatUtils.formatDuration(Duration.ofSeconds(elapsedTime++).toMillis(), "HH:mm:ss"));
        }), new KeyFrame(javafx.util.Duration.seconds(1)));
        stopWatch.setCycleCount(Animation.INDEFINITE);
        stopWatch.play();
    }

    private void displayGameState() {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                ToggleButton toggleButton = (ToggleButton) gameGrid.getChildren().get(i * 4 + j);
                toggleButton.setSelected(false);
                toggleButton.getStylesheets().clear();
                toggleButton.getStylesheets().add(buttonSytles.get(gameState.getActualState()[i][j]));
                if (gameState.getActualState()[i][j] == 0) {
                    toggleButton.setDisable(true);
                }
            }
    }

    public void handleClickOnPiece(MouseEvent mouseEvent) throws IOException {
        ToggleButton source = (ToggleButton) mouseEvent.getSource();
        Position position = Position.builder()
                .column(GridPane.getColumnIndex(source))
                .row(GridPane.getRowIndex(source))
                .build();
        if (from == null) {
            from = position;
            enableEmptySpaces();
        } else {
            to = position;
            movePiece((Node) mouseEvent.getSource());
        }
    }

    private void enableEmptySpaces() {
        for (int i = 0; i < 4; ++i)
            for (int j = 0; j < 4; ++j) {
                if (gameState.getActualState()[i][j] == 0) {
                    gameGrid.getChildren().get(i * 4 + j).setDisable(false);
                }
            }
    }

    private void movePiece(Node source) throws IOException {
        if (gameState.isApplicable(from, to)) {
            gameState.op(from, to);
            if (gameState.isGameEnded()) {
                gameOver.setValue(true);
            }
        } else {
            log.info("Not permitted movement!");
        }
        from = null;
        to = null;
        displayGameState();
        setTurnIndicator();
    }

    public void onRestartButtonClicked(MouseEvent mouseEvent) {
        log.debug("{} is pressed", ((Button) mouseEvent.getSource()).getText());
        stopWatch.stop();
        startGame();
    }

    public void onPauseButtonClicked(MouseEvent mouseEvent) {
        Button button = (Button)mouseEvent.getSource();
        log.debug("{} is pressed", button.getText());
        if (button.getText().equals("Pause")) {
            log.info("Game pausing...");
            button.setText("Play");
            pauseGame();
        } else {
            log.info("Game continuing...");
            button.setText("Pause");
            continueGame();
        }
    }

    private void continueGame() {
        stopWatch.play();
        gameGrid.setDisable(false);
    }

    private void pauseGame() {
        stopWatch.pause();
        gameGrid.setDisable(true);
    }

    public void onGiveUpButtonClicked(MouseEvent mouseEvent) throws IOException {
        log.debug("{} is pressed", ((Button)mouseEvent.getSource()).getText());
        gameState.playerGaveUp();
        gameOver.setValue(true);
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/central/start.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
        stage.show();

    }
}
