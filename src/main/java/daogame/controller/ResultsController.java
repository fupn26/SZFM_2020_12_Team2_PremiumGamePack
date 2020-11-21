package daogame.controller;

import daogame.data.GameResult;
import daogame.data.GameResultDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.time.Duration;
import java.time.ZonedDateTime;

@Slf4j
public class ResultsController {
    @Inject
    private FXMLLoader fxmlLoader;

    @Inject
    private GameResultDao gameResultDao;

    @FXML
    private Label winnerLabel;

    @FXML
    private TableView resultTable;

    @FXML
    private TableView resultTable2;

    @FXML
    private TableColumn<GameResult, String> player1Column;

    @FXML
    private TableColumn<GameResult, String> player2Column;

    @FXML
    private TableColumn<GameResult, String> winnerColumn;

    @FXML
    private TableColumn<GameResult, Duration> durationColumn;

    @FXML
    private TableColumn<GameResult, ZonedDateTime> dateColumn;

    @FXML
    private TableColumn<GameResult, String> player1Column2;

    @FXML
    private TableColumn<GameResult, String> player2Column2;

    @FXML
    private TableColumn<GameResult, String> winnerColumn2;

    @FXML
    private TableColumn<GameResult, Duration> durationColumn2;

    @FXML
    private TableColumn<GameResult, ZonedDateTime> dateColumn2;
}
