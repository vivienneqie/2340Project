package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WelcomeController {

    private MainFXApp mainFXApplication;


    public void setMainApp(MainFXApp mainFXApp) {
        mainFXApplication = mainFXApp;}

    @FXML
    public Button login;

    @FXML
    public Button register;

    @FXML
    public void onRegPressed() {
        Stage stage = (Stage) register.getScene().getWindow(); //cast as Stage
        stage.close(); //close welcome screen
        mainFXApplication.goToRegistration();
    }

    @FXML
    public void onLoginPressed() {
        Stage stage = (Stage) login.getScene().getWindow(); //cast as Stage
        stage.close(); //close welcome screen
        mainFXApplication.goToLogin();
    }
}
