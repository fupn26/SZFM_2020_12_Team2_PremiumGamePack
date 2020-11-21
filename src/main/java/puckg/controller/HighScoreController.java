package puckg.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import puckg.data.GameData;
import puckg.data.GameDataDao;

import javax.inject.Inject;
import java.time.Duration;
import java.time.ZonedDateTime;

public class HighScoreController {

    @Inject
    private FXMLLoader fxmlLoader;

    @Inject
    private GameDataDao gameDataDao;

    @FXML
    private TableView<GameData> highScoreTable;

    @FXML
    private TableView<GameData> highScoreTable2;

    @FXML
    private TableColumn<GameData, String> winner;

    @FXML
    private TableColumn<GameData, Integer> winnerPoints;

    @FXML
    private TableColumn<GameData, String> second;

    @FXML
    private TableColumn<GameData, Integer> secondPoints;

    @FXML
    private TableColumn<GameData, Duration> duration;

    @FXML
    private TableColumn<GameData, ZonedDateTime> created;

    @FXML
    private TableColumn<GameData, String> winner2;

    @FXML
    private TableColumn<GameData, Integer> winnerPoints2;

    @FXML
    private TableColumn<GameData, String> second2;

    @FXML
    private TableColumn<GameData, Integer> secondPoints2;

    @FXML
    private TableColumn<GameData, Duration> duration2;

    @FXML
    private TableColumn<GameData, ZonedDateTime> created2;

    @FXML
    private Button exitButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button mainMenuButton;
}
