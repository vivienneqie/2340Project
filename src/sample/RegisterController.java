package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
        //Actor newUser = new Actor(unText.getText(), pwText.getText(), fnText.getText(), (AccountTypes) accBox.getValue());
        register.setOnAction(e -> {
            if (fnText.getText().equals("") || lnText.getText().equals("") || unText.getText().equals("")
                    || pwText.getText().equals("") || pwcText.getText().equals("") || emailText.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("One or more of the fields was not filled out correctly");
                alert.setContentText("Please enter values for all of the required fields.");
                alert.showAndWait();
            } else {
                if (pwText.getText().equals(pwcText.getText())) {
                    User newUser = new User(unText.getText(), pwText.getText(),
                            emailText.getText(), fnText.getText(), lnText.getText());
                    _dialogStage.close();
                    mainFXApplication.goToLogin();
//                    FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
//                    try {
//                        Parent root = (Parent) loader.load();
//                        Scene scene = new Scene(root);
//                        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//                        stage.setScene(scene);
//                        stage.show();
//                    } catch (IOException ie) {
//                        ie.printStackTrace();
//                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Passwords do not match");
                    alert.setContentText("Password confirmation is not identical to your password.");
                    alert.showAndWait();
                }
            }
        });
    }

    @FXML
    private void handleCancel() {
        _dialogStage.close();
        mainFXApplication.goToLogin();
    }

}