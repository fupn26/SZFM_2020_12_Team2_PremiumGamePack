package central.javafx.controller;

import central.javafx.GameApplication;
import com.jfoenix.controls.JFXButton;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class StartController {
//    @FXML
//    private Button gameOneButton;
//
//    @FXML
//    private Button gameTwoButton;
//
//    @FXML
//    private Button gameThreeButton;
//
//    @FXML
//    private Button gameFourButton;

    @FXML
    private BorderPane frontBorderPane;

    @FXML
    private JFXButton startButton;

    @FXML
    private JFXButton previousButton;

    @FXML
    private JFXButton nextButton;

    @FXML
    private StackPane centreContainer;

    @FXML
    private JFXButton exitButton;

    @FXML
    private HBox buttonBarContainer;


    private final IntegerProperty titleIndex = new SimpleIntegerProperty();
    private Parent[] gameTitles;
    private Parent[] gameRules;

    @FXML
    public void initialize() throws IOException {
        gameTitles = new Parent[4];
        gameTitles[0] = FXMLLoader.load(getClass().getResource("/fxml/central/dao.fxml"));
        gameTitles[1] = FXMLLoader.load(getClass().getResource("/fxml/central/minesweeper.fxml"));
        gameTitles[2] = FXMLLoader.load(getClass().getResource("/fxml/central/puckg.fxml"));
        gameTitles[3] = FXMLLoader.load(getClass().getResource("/fxml/central/triplepuck.fxml"));

        gameRules = new Parent[4];
        gameRules[0] = FXMLLoader.load(getClass().getResource("/fxml/daogame/dao_rules.fxml"));
        gameRules[1] = FXMLLoader.load(getClass().getResource("/fxml/minesweeper/minesweeper_rules.fxml"));
        gameRules[2] = FXMLLoader.load(getClass().getResource("/fxml/puckg/puckg_rules.fxml"));
        gameRules[3] = FXMLLoader.load(getClass().getResource("/fxml/triplepuck/triplepuck_rules.fxml"));

        titleIndex.addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() == 0) {
                previousButton.setVisible(false);
            } else if (newValue.intValue() == gameTitles.length - 1) {
                nextButton.setVisible(false);
            } else {
                previousButton.setVisible(true);
                nextButton.setVisible(true);
            }
        });
        titleIndex.setValue(0);

        centreContainer.getChildren().add(0, gameTitles[titleIndex.get()]);

        frontBorderPane.addEventHandler(EventType.ROOT, event -> {
            int size = centreContainer.getChildren().size();
            if (size > 0)
                centreContainer.getChildren().get(size - 1).fireEvent(event);
        });
    }

    public void handleExit (ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void handleGameOneButton (ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(GameApplication.class.getResource("/fxml/daogame/welcome.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void handleGameTwoButton (ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(GameApplication.class.getResource("/fxml/minesweeper/launch.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void handleGameThreeButton (ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(GameApplication.class.getResource("/fxml/triplepuck/launch.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void handleGameFourButton (ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/puckg/start.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void loadNextGameTitle(ActionEvent actionEvent) throws IOException {
        titleIndex.setValue(titleIndex.get() + 1);

        Parent root = gameTitles[titleIndex.get()];
        Scene scene = centreContainer.getScene();

        root.translateXProperty().set(scene.getWidth());
        centreContainer.getChildren().add(1, root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event -> {
            previousButton.setDisable(false);
            nextButton.setDisable(false);
            centreContainer.getChildren().remove(0);
        });

        previousButton.setDisable(true);
        nextButton.setDisable(true);
        timeline.play();
    }

    public void loadPreviousGameTitle(ActionEvent actionEvent) throws IOException {
        titleIndex.setValue(titleIndex.get() - 1);

        Parent root = gameTitles[titleIndex.get()];
        Scene scene = centreContainer.getScene();

        root.translateXProperty().set(-scene.getWidth());
        centreContainer.getChildren().add(1, root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);

        timeline.setOnFinished(event -> {
            previousButton.setDisable(false);
            nextButton.setDisable(false);
            centreContainer.getChildren().remove(0);
        });

        previousButton.setDisable(true);
        nextButton.setDisable(true);
        timeline.play();
    }

    public void handleGameStart(ActionEvent actionEvent) throws IOException{
        Parent root = null;
        switch (titleIndex.get()) {
            case 0:
                root = FXMLLoader.load(GameApplication.class.getResource("/fxml/daogame/welcome.fxml"));
                break;
            case 1:
                root = FXMLLoader.load(GameApplication.class.getResource("/fxml/minesweeper/launch.fxml"));
                break;
            case 2:
                root = FXMLLoader.load(getClass().getResource("/fxml/puckg/start.fxml"));
                break;
            case 3:
                root = FXMLLoader.load(GameApplication.class.getResource("/fxml/triplepuck/launch.fxml"));
                break;
        }
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void handleOpeningRules(ActionEvent actionEvent){
        if (centreContainer.getChildren().contains(gameRules[titleIndex.get()])) {
            hideRule();
        } else {
            showRule();
        }
    }

    private void hideRule() {
        Parent root = gameRules[titleIndex.get()];
        Scene scene = centreContainer.getScene();

//        root.translateYProperty().set(scene.getHeight());

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), scene.getHeight() - buttonBarContainer.getHeight(), Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);

        timeline.setOnFinished(event -> {
            if (titleIndex.get() != 0)
                previousButton.setVisible(true);
            if (titleIndex.get() != 3)
                nextButton.setVisible(true);
            centreContainer.getChildren().remove(root);
        });

        timeline.play();
    }

    private void showRule() {
        Parent root = gameRules[titleIndex.get()];
        Scene scene = centreContainer.getScene();

        root.translateYProperty().set(scene.getHeight() - buttonBarContainer.getHeight());
        centreContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);

        previousButton.setVisible(false);
        nextButton.setVisible(false);

        timeline.play();
    }

}
