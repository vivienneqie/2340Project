package sample;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class WelcomeController {

    private MainFXApp mainFXApplication;

    private Stage _dialogStage;

    /**
     * Method to set the main application
     * @param mainFXApp MainFXApp
     */
    public void setMainApp(MainFXApp mainFXApp) {
        mainFXApplication = mainFXApp;}

    /**
     * Method to set the dialog stage
     * @param dialogStage Stage
     */
    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    /**
     * Method to handle actions when the register button is pressed
     */
    @FXML
    public void onRegPressed() {
        _dialogStage.close();
        mainFXApplication.goToRegistration();
    }

    /**
     * Method to handle actions when the login button is pressed
     */
    @FXML
    public void onLoginPressed() {
        _dialogStage.close();
        mainFXApplication.goToLogin();
    }
}
