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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
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
    private JFXButton startButton;

    @FXML
    private JFXButton previousButton;

    @FXML
    private JFXButton nextButton;

    @FXML
    private StackPane centreContainer;

    @FXML
    private JFXButton exitButton;

    private final IntegerProperty titleIndex = new SimpleIntegerProperty();
    private Parent[] gameTitles;
}
