package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Mitchell
 */
public class HomeController {
    @FXML
    private Button reportButton;

    @FXML
    private Button viewReports;

    @FXML
    private Button editProfile;

    private MainFXApp mainFXAppApplication;

    private Stage _dialogStage;

    /**
     *
     * @param mainFXApp
     */
    public void setMainApp(MainFXApp mainFXApp) {
        mainFXAppApplication = mainFXApp;}

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
    private void initialize() {
        //TODO:set up more buttons if the user logging in is a worker or manager

    }

    /**
     *
     */
    @FXML
    public void handleLogout() {
        _dialogStage.close();
        mainFXAppApplication.goToLogin();
    }

    /**
     *
     */
    @FXML
    private void handleReportButton() {
        _dialogStage.close();
        mainFXAppApplication.goToSubmission();
    }

    /**
     *
     */
    @FXML
    private void handleViewSubmission() {
        _dialogStage.close();
        mainFXAppApplication.goToReports();
    }

    /**
     *
     */
    @FXML
    private void handleEditProfile() {
        _dialogStage.close();
        mainFXAppApplication.goToEditProfile();
    }
}