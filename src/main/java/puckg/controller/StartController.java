package puckg.controller;

import com.gluonhq.ignite.guice.GuiceContext;
import com.google.inject.AbstractModule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

public class StartController {

    private GuiceContext context = new GuiceContext(this, () -> List.of(
            new AbstractModule() {}
    ));

    @Inject
    private FXMLLoader fxmlLoader;

    @FXML
    private TextField player1NameTextField;

    @FXML
    private TextField player2NameTextField;

    @FXML
    private Label errorLabel1;

    @FXML
    private Label errorLabel2;

    @FXML
    private TextArea ruleArea;

    @FXML
    private Button rulesButton;

    @FXML
    public void initialize() {
        ruleArea.setVisible(false);
        context.init();
    }

    public void startAction(ActionEvent actionEvent) throws IOException {
        if(player1NameTextField.getText().isEmpty()) {
            errorLabel1.setText("Enter Player1's name!");
        } else if(player2NameTextField.getText().isEmpty()) {
            errorLabel2.setText("Enter Player2's name!");
        } else {
            fxmlLoader.setLocation(getClass().getResource("/fxml/puckg/game.fxml"));
            Parent root = fxmlLoader.load();
            fxmlLoader.<GameController>getController().setPlayer1Name(player1NameTextField.getText());
            fxmlLoader.<GameController>getController().setPlayer2Name(player2NameTextField.getText());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    public void handleRules(ActionEvent actionEvent) {
        if(!ruleArea.visibleProperty().getValue()) {
            ruleArea.setVisible(true);
            rulesButton.setText("Hide rules");
        } else {
            ruleArea.setVisible(false);
            rulesButton.setText("Show rules");
        }
    }
}
