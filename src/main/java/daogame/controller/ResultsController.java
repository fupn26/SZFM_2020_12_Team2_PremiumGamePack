package daogame.controller;

import com.jfoenix.controls.JFXToggleButton;
import daogame.data.GameResult;
import daogame.data.GameResultDao;
import daogame.data.GameResultJson;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DurationFormatUtils;
import swegame.data.GResult;

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
    private VBox previousResultsView;

    @FXML
    private VBox top5ResultsView;

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

    public void onRematchButtonClicked(MouseEvent mouseEvent) throws IOException {
        log.debug("{} is pressed", ((Button)mouseEvent.getSource()).getText());
        log.info("Game launching...");
        fxmlLoader.setLocation(getClass().getResource("/fxml/daogame/game.fxml"));
        Parent root = fxmlLoader.load();
        fxmlLoader.<daogame.controller.GameController>getController().setPlayerNames(gameResultDao.findLast(1).get(0).getPlayer1(),
                gameResultDao.findLast(1).get(0).getPlayer2());
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
        stage.show();
    }

    public void onHomeButtonClicked(MouseEvent mouseEvent) throws IOException {
        log.debug("{} is pressed", ((Button)mouseEvent.getSource()).getText());
        fxmlLoader.setLocation(getClass().getResource("/fxml/central/start.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
        stage.show();
    }

    public void onExitButtonClicked(MouseEvent mouseEvent) {
        log.debug("{} is pressed", ((Button)mouseEvent.getSource()).getText());
        log.info("Program closing...");
        Platform.exit();
    }

    public void handleDeleteButtonClicked(ActionEvent actionEvent) {
        gameResultDao.deleteData();

        ObservableList<GameResult> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(new ArrayList<GameResult>());

        resultTable.setItems(observableResult);
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
