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
        var prevResults = gameResultDao.findAllDateOrdered();
        winnerLabel.setText("The winner is " + prevResults.get(0).getWinner());

        log.debug("Loading high scores...");
        player1Column.setCellValueFactory(new PropertyValueFactory<>("player1"));
        player2Column.setCellValueFactory(new PropertyValueFactory<>("player2"));
        winnerColumn.setCellValueFactory(new PropertyValueFactory<>("winner"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("created"));


        durationColumn.setCellFactory(column -> {
            TableCell<GameResult, Duration> cell = new TableCell<>() {
                @Override
                protected void updateItem(Duration item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(DurationFormatUtils.formatDuration(item.toMillis(), "H:mm:ss"));
                    }
                }
            };
            return cell;
        });

        dateColumn.setCellFactory(column -> {
            TableCell<GameResult, ZonedDateTime> cell = new TableCell<>() {
                private final DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

                @Override
                protected void updateItem(ZonedDateTime item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item.format(formatter));
                    }
                }
            };
            return cell;
        });

        player1Column2.setCellValueFactory(new PropertyValueFactory<>("player1"));
        player2Column2.setCellValueFactory(new PropertyValueFactory<>("player2"));
        winnerColumn2.setCellValueFactory(new PropertyValueFactory<>("winner"));
        durationColumn2.setCellValueFactory(new PropertyValueFactory<>("duration"));
        dateColumn2.setCellValueFactory(new PropertyValueFactory<>("created"));


        durationColumn2.setCellFactory(column -> {
            TableCell<GameResult, Duration> cell = new TableCell<>() {
                @Override
                protected void updateItem(Duration item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(DurationFormatUtils.formatDuration(item.toMillis(), "H:mm:ss"));
                    }
                }
            };
            return cell;
        });

        dateColumn2.setCellFactory(column -> {
            TableCell<GameResult, ZonedDateTime> cell = new TableCell<>() {
                private final DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

                @Override
                protected void updateItem(ZonedDateTime item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item.format(formatter));
                    }
                }
            };
            return cell;
        });


        ObservableList<GameResult> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(prevResults);

        resultTable.setItems(observableResult);

        displayTopFive();
    }

    public void displayTopFive() throws FileNotFoundException {
        File file = new File("daogame.json");
        ArrayList<GameResult> resultList = GameResultJson.readJson(file);
        ObservableList<GameResult> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(resultList);

        resultTable2.setItems(observableResult);
    }
}
