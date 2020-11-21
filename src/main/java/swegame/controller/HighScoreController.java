package swegame.controller;

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
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DurationFormatUtils;

import puckg.data.GameData;
import puckg.data.GameDataJson;
import swegame.data.GResult;
import swegame.data.GResultDao;

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
    private GResultDao gameResultDao;

    @FXML
    private TableView<GResult> highScoreTable;

    @FXML
    private TableView<GResult> highScoreTable2;

    @FXML
    private TableColumn<GResult, String> redplayer;

    @FXML
    private TableColumn<GResult, String> redplayer2;

    @FXML
    private TableColumn<GResult, String> blueplayer;

    @FXML
    private TableColumn<GResult, String> blueplayer2;

    @FXML
    private TableColumn<GResult, String> winner;

    @FXML
    private TableColumn<GResult, String> winner2;

    @FXML
    private TableColumn<GResult, Integer> steps;

    @FXML
    private TableColumn<GResult, Integer> steps2;

    @FXML
    private TableColumn<GResult, Duration> duration;

    @FXML
    private TableColumn<GResult, Duration> duration2;

    @FXML
    private TableColumn<GResult, ZonedDateTime> created;

    @FXML
    private TableColumn<GResult, ZonedDateTime> created2;

    @FXML
    private Button mainMenuButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button deleteButton;

    private String redPlayerName;
    private String bluePlayerName;

    public void setPlayerNames(String redPlayerName, String bluePlayerName) {
        this.redPlayerName = redPlayerName;
        this.bluePlayerName = bluePlayerName;
    }

    @FXML
    private void initialize() throws FileNotFoundException {
        List<GResult> highScoreList = gameResultDao.findLast(10);


        redplayer.setCellValueFactory(new PropertyValueFactory<>("redplayer"));
        blueplayer.setCellValueFactory(new PropertyValueFactory<>("blueplayer"));
        winner.setCellValueFactory(new PropertyValueFactory<>("winner"));
        steps.setCellValueFactory(new PropertyValueFactory<>("steps"));
        duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        created.setCellValueFactory(new PropertyValueFactory<>("created"));


        duration.setCellFactory(column -> {
            TableCell<GResult, Duration> cell = new TableCell<GResult, Duration>() {
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
            TableCell<GResult, ZonedDateTime> cell = new TableCell<GResult, ZonedDateTime>() {
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



    }
}