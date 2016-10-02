package sample;

import javafx.stage.Stage;

/**
 * Created by Mitchell on 9/28/2016.
 */
public class HomeController {
    private MainFXApp mainFXAppApplication;

    private Stage _dialogStage;

    public void setMainApp(MainFXApp mainFXApp) {
        mainFXAppApplication = mainFXApp;}

    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    public void handleLogout() {
        System.exit(0);
    }
}
