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

    private User activeuser;

    /** flag to signal whether dialog was closed normally */
    private boolean _okClicked = false;

    private MainFXApp mainFXAppApplication;

    /**
     * Method to set the main application
     * @param mainFXApp MainFXApp
     */
    public void setMainApp(MainFXApp mainFXApp) {
        mainFXAppApplication = mainFXApp;}

    /**
     * Method to initialize the view
     */
    @FXML
    private void initialize() {
    }

    /**
     * Method to set the dialog stage
     * @param dialogStage Stage
     */
    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    /**
     * Method to check if the click was successful
     * @return boolean
     */
    public boolean isOkClicked() {
        return _okClicked;
    }

    /**
     * Method to handle actions when the login button is pressed
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
     * Method to handle actions when the cancel button is presed
     */
    @FXML
    private void handleCancel() {
        _dialogStage.close();
        mainFXAppApplication.goToWelcome();
    }

    /**
     * Method to get login pane
     * @return BorderPane
     */
    public BorderPane getLoginPane() {
        return loginPane;
    }

    /**
     * Method to check if the input username and password were valid
     * @return boolean
     */
    private boolean isInputValid() {
        //Mapped by username and user for easy search by username
        Map<String, User> users = User.getUserDB();
        if (users.get(userText.getText()) != null) {
            User theUser = users.get(userText.getText());
            if (passText.getText().equals(theUser.getPassword())) {
                setActiveUser(theUser);
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * saves an instance of the active user once they have been authenticated
     * @param u the user to be set as active
     */
    private void setActiveUser(User u) {
        activeuser = u;
    }

    /**
     * returns the active user
     * @return the user currently logged in
     */
    public User getActiveUser() {
        return activeuser;
    }
}
