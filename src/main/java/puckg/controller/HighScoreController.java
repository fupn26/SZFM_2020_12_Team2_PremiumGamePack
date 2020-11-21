package puckg.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.commons.lang3.time.DurationFormatUtils;
import puckg.data.GameData;
import puckg.data.GameDataDao;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

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

    @FXML
    private void initialize() {
        List<GameData> highScoreList = gameDataDao.findBestByTime(30);

        winner.setCellValueFactory(new PropertyValueFactory<>("winner"));
        winnerPoints.setCellValueFactory(new PropertyValueFactory<>("winnerPoints"));
        second.setCellValueFactory(new PropertyValueFactory<>("second"));
        secondPoints.setCellValueFactory(new PropertyValueFactory<>("secondPoints"));
        duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        created.setCellValueFactory(new PropertyValueFactory<>("created"));

        duration.setCellFactory(column -> {
            TableCell<GameData, Duration> cell = new TableCell<GameData, Duration>() {
                @Override
                protected void updateItem(Duration item, boolean empty) {
                    super.updateItem(item, empty);
                    if(empty) {
                        setText(null);
                    } else {
                        setText(DurationFormatUtils.formatDuration(item.toMillis(),"H:mm:ss"));
                    }
                }
            };
            return cell;
        });

        created.setCellFactory(column -> {
            TableCell<GameData, ZonedDateTime> cell = new TableCell<>() {
                private DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

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

        winner2.setCellValueFactory(new PropertyValueFactory<>("winner"));
        winnerPoints2.setCellValueFactory(new PropertyValueFactory<>("winnerPoints"));
        second2.setCellValueFactory(new PropertyValueFactory<>("second"));
        secondPoints2.setCellValueFactory(new PropertyValueFactory<>("secondPoints"));
        duration2.setCellValueFactory(new PropertyValueFactory<>("duration"));
        created2.setCellValueFactory(new PropertyValueFactory<>("created"));

        duration2.setCellFactory(column -> {
            TableCell<GameData, Duration> cell = new TableCell<GameData, Duration>() {
                @Override
                protected void updateItem(Duration item, boolean empty) {
                    super.updateItem(item, empty);
                    if(empty) {
                        setText(null);
                    } else {
                        setText(DurationFormatUtils.formatDuration(item.toMillis(),"H:mm:ss"));
                    }
                }
            };
            return cell;
        });

        created2.setCellFactory(column -> {
            TableCell<GameData, ZonedDateTime> cell = new TableCell<>() {
                private DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

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

        ObservableList<GameData> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(highScoreList);

        highScoreTable.setItems(observableResult);
    }
}
