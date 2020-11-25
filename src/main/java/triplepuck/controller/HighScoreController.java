package triplepuck.controller;

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

import triplepuck.data.GResult;
import triplepuck.data.GResultDao;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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

        redplayer2.setCellValueFactory(new PropertyValueFactory<>("redplayer"));
        blueplayer2.setCellValueFactory(new PropertyValueFactory<>("blueplayer"));
        winner2.setCellValueFactory(new PropertyValueFactory<>("winner"));
        steps2.setCellValueFactory(new PropertyValueFactory<>("steps"));
        duration2.setCellValueFactory(new PropertyValueFactory<>("duration"));
        created2.setCellValueFactory(new PropertyValueFactory<>("created"));



        duration2.setCellFactory(column -> {
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

        created2.setCellFactory(column -> {
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

        ObservableList<GResult> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(highScoreList);

        highScoreTable.setItems(observableResult);
    }

    public void handleRestartButton(ActionEvent actionEvent) throws IOException {
        fxmlLoader.setLocation(getClass().getResource("/fxml/triplepuck/launch.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void handleRematchButton(ActionEvent actionEvent) throws IOException {
        fxmlLoader.setLocation(getClass().getResource("/fxml/triplepuck/game.fxml"));
        Parent root = fxmlLoader.load();
        fxmlLoader.<GameController>getController().setPlayerNames(redPlayerName,bluePlayerName);
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
        List<GResult> highScoreList = gameResultDao.findLast(10);

        ObservableList<GResult> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(highScoreList);

        highScoreTable.setItems(observableResult);
    }

    public void handleExitButton (ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}