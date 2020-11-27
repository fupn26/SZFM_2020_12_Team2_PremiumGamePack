package minesweeper.controller;

import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import minesweeper.data.Result;
import minesweeper.data.ResultDao;
import minesweeper.data.ResultJson;
import org.apache.commons.lang3.time.DurationFormatUtils;
import puckg.data.GameData;
import puckg.data.GameDataJson;

import javax.inject.Inject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class HighScoreController {

    @Inject
    private FXMLLoader fxmlLoader;

    @Inject
    private ResultDao gameResultDao;

    @FXML
    private TableView<Result> highScoreTable;

    @FXML
    private TableView<Result> highScoreTable2;

    @FXML
    private TableColumn<Result, String> player;

    @FXML
    private TableColumn<Result, String> player2;

    @FXML
    private TableColumn<Result, Duration> duration;

    @FXML
    private TableColumn<Result, Duration> duration2;

    @FXML
    private TableColumn<Result, ZonedDateTime> created;

    @FXML
    private TableColumn<Result, ZonedDateTime> created2;

    @FXML
    private Button mainMenuButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button exitButton;

    @FXML
    private VBox previousResultsView;

    @FXML
    private VBox top5ResultsView;

    @FXML
    private void initialize() throws FileNotFoundException {
        List<Result> highScoreList = gameResultDao.findBest(10);

        player.setCellValueFactory(new PropertyValueFactory<>("playerName"));
        duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        created.setCellValueFactory(new PropertyValueFactory<>("created"));

        duration.setCellFactory(column -> {
            TableCell<Result, Duration> cell = new TableCell<Result, Duration>() {
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
            TableCell<Result, ZonedDateTime> cell = new TableCell<Result, ZonedDateTime>() {
                private DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
                @Override
                protected void updateItem(ZonedDateTime item, boolean empty) {
                    super.updateItem(item, empty);
                    if(empty) {
                        setText(null);
                    } else {
                        setText(item.format(formatter));
                    }
                }
            };
            return cell;
        });

        player2.setCellValueFactory(new PropertyValueFactory<>("playerName"));
        duration2.setCellValueFactory(new PropertyValueFactory<>("duration"));
        created2.setCellValueFactory(new PropertyValueFactory<>("created"));

        duration2.setCellFactory(column -> {
            TableCell<Result, Duration> cell = new TableCell<Result, Duration>() {
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
            TableCell<Result, ZonedDateTime> cell = new TableCell<Result, ZonedDateTime>() {
                private DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
                @Override
                protected void updateItem(ZonedDateTime item, boolean empty) {
                    super.updateItem(item, empty);
                    if(empty) {
                        setText(null);
                    } else {
                        setText(item.format(formatter));
                    }
                }
            };
            return cell;
        });

        ObservableList<Result> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(highScoreList);

        highScoreTable.setItems(observableResult);

        displayTopFive();
    }

    public void handleRestartButton(ActionEvent actionEvent) throws IOException {
        fxmlLoader.setLocation(getClass().getResource("/fxml/minesweeper/launch.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void handleMainMenuButton (ActionEvent actionEvent) throws IOException {
        fxmlLoader.setLocation(getClass().getResource("/fxml/central/start.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void handleDeleteButton (ActionEvent actionEvent) {
        gameResultDao.deleteData();
        List<Result> highScoreList = gameResultDao.findBest(10);

        ObservableList<Result> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(highScoreList);

        highScoreTable.setItems(observableResult);
    }

    public void handleExitButton (ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void displayTopFive() throws FileNotFoundException {
        File file = new File("minesweeper.json");
        ArrayList<Result> resultList = ResultJson.readJson(file);
        ObservableList<Result> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(resultList);

        highScoreTable2.setItems(observableResult);
    }

    public void handleResultViewSwitch(ActionEvent actionEvent) {
        if (((JFXToggleButton)(actionEvent.getSource())).isSelected()) {
            previousResultsView.setVisible(true);
            top5ResultsView.setVisible(false);
        } else {
            previousResultsView.setVisible(false);
            top5ResultsView.setVisible(true);
        }
    }
}