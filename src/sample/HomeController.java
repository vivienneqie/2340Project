package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Mitchell
 * @author Vivienne
 */
public class HomeController {
    @FXML
    private Button reportButton;

    @FXML
    private Button viewReports;

    @FXML
    private Button editProfile;

    @FXML
    private Button viewMap;

    private MainFXApp mainFXAppApplication;

    private Stage _dialogStage;

    /**
     * Method to set the main application
     * @param mainFXApp MainFXApp
     */
    public void setMainApp(MainFXApp mainFXApp) {
        mainFXAppApplication = mainFXApp;}

    /**
     * Method to set the dialog stage
     * @param dialogStage Stage
     */
    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    /**
     * Method to initialize the view
     */
    @FXML
    private void initialize() {
        //TODO:set up more buttons if the user logging in is a worker or manager

    }

    /**
     * Method to handle actions when the logout button is pressed
     */
    @FXML
    public void handleLogout() {
        _dialogStage.close();
        mainFXAppApplication.goToLogin();
    }

    /**
     * Method to handle actions when the submit report button is pressed
     */
    @FXML
    private void handleReportButton() {
        _dialogStage.close();
        mainFXAppApplication.goToSubmission();
    }

    /**
     * Method to handle actions when the view reports button is pressed
     */
    @FXML
    private void handleViewSubmission() {
        _dialogStage.close();
        mainFXAppApplication.goToReports();
    }

    /**
     * Method to handle actions when the edit profile button is pressed
     */
    @FXML
    private void handleEditProfile() {
        _dialogStage.close();
        mainFXAppApplication.goToEditProfile();
    }

    @FXML
    private void handleMapView() {
        _dialogStage.close();
        mainFXAppApplication.goToMapView();
    }
}