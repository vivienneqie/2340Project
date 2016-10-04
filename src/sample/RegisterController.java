package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Mitchell on 10/1/2016.
 */
public class RegisterController {
    @FXML
    private BorderPane regPane;

    @FXML
    private TextField fnText;

    @FXML
    private TextField lnText;

    @FXML
    private TextField emailText;

    @FXML
    private TextField unText;

    @FXML
    private TextField pwText;

    @FXML
    private TextField pwcText;

    @FXML
    private ComboBox accBox;

    @FXML
    private Button register;

    private Stage _dialogStage;

    /** flag to signal whether dialog was closed normally */
    private boolean _okClicked = false;

    private MainFXApp mainFXApplication;

    public void setMainApp(MainFXApp mainFXApp) { mainFXApplication = mainFXApp; }

    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    @FXML
    private void initialize() {
        ObservableList aList = FXCollections.observableArrayList(AccountTypes.values());
        accBox.getItems().clear();
        accBox.setItems(aList);
    }

    @FXML
    private void handleRegister() {
        //_dialogStage.close()
        //mainFXApplication.goToLogin();
        Actor newUser = new Actor(unText.getText(), pwText.getText(), fnText.getText(), (AccountTypes) accBox.getValue());
        register.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
            try {
                Parent root = (Parent) loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        });

    }

    @FXML
    private void handleCancel() {
        System.exit(0);
    }

}