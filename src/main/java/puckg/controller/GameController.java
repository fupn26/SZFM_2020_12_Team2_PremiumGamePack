package puckg.controller;

import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import puckg.state.TableState;

import javax.inject.Inject;
import java.time.Instant;
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
}
