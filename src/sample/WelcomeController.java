package sample;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class WelcomeController {

    private MainFXApp mainFXApplication;

    private Stage _dialogStage;

    /**
     *
     * @param mainFXApp
     */
    public void setMainApp(MainFXApp mainFXApp) {
        mainFXApplication = mainFXApp;}

    /**
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    /**
     *
     */
    @FXML
    public void onRegPressed() {
        _dialogStage.close();
        mainFXApplication.goToRegistration();
    }

    /**
     *
     */
    @FXML
    public void onLoginPressed() {
        _dialogStage.close();
        mainFXApplication.goToLogin();
    }
}
