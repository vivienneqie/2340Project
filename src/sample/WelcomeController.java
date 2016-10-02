package sample;

import javafx.fxml.FXML;

public class WelcomeController {

    private MainFXApp mainFXApplication;


    public void setMainApp(MainFXApp mainFXApp) {
        mainFXApplication = mainFXApp;}


    @FXML
    public void onRegPressed() { mainFXApplication.goToRegistration(); }

    @FXML
    public void onLoginPressed() {
        mainFXApplication.goToLogin();
    }
}
