package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Map;

/**
 * @author Brittany
 * @author Mitchell
 */
public class LoginController {
    @FXML
    private BorderPane loginPane;

    @FXML
    private TextField userText;

    @FXML
    private TextField passText;

    @FXML
    private Button cancel;

    private Stage _dialogStage;

    /** flag to signal whether dialog was closed normally */
    private boolean _okClicked = false;

    private MainFXApp mainFXAppApplication;

    /**
     *
     * @param mainFXApp
     */
    public void setMainApp(MainFXApp mainFXApp) {
        mainFXAppApplication = mainFXApp;}

    /**
     *
     */
    @FXML
    private void initialize() {
    }

    /**
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    /**
     *
     * @return
     */
    public boolean isOkClicked() {
        return _okClicked;
    }

    /**
     *
     */
    @FXML
    private void handleOKPressed() {
        //First validate the data to ensure it is at least reasonable
        if (isInputValid()) {
            //signal success and close this dialog window.
            _okClicked = true;
            _dialogStage.close();
            mainFXAppApplication.goToHome();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Login");
            alert.setHeaderText("Username and/or Password Not Found");
            alert.setContentText("Username and/or password was entered incorrectly.");
            alert.showAndWait();
        }
    }

    /**
     *
     */
    @FXML
    private void handleCancel() {
        _dialogStage.close();
        mainFXAppApplication.goToWelcome();
    }

    /**
     *
     * @return
     */
    public BorderPane getLoginPane() {
        return loginPane;
    }

    /**
     *
     * @return
     */
    private boolean isInputValid() {
        //Mapped by username and user for easy search by username
        Map<String, User> users = User.getUserDB();
        if (users.get(userText.getText()) != null) {
            User theUser = users.get(userText.getText());
            return passText.getText().equals(theUser.getPassword());
        }
        return false;
    }
}
