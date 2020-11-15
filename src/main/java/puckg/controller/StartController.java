package puckg.controller;

import com.gluonhq.ignite.guice.GuiceContext;
import com.google.inject.AbstractModule;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.inject.Inject;
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
}
