package daogame.controller;

import daogame.data.GameResult;
import daogame.data.GameResultDao;
import daogame.data.GameResultJson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DurationFormatUtils;

import javax.inject.Inject;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

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

    @FXML
    public void initialize() throws FileNotFoundException {
        //TODO implement filling of the result tables
        return;
    }

    public void displayTopFive() throws FileNotFoundException {
        File file = new File("daogame.json");
        ArrayList<GameResult> resultList = GameResultJson.readJson(file);
        ObservableList<GameResult> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(resultList);

        resultTable2.setItems(observableResult);
    }
}
