package sample;

import javafx.collections.FXCollections;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.scene.control.*;

/**
 * Created by Vivienne on 10/17/2016.
 */
public class EditProfileController {
    @FXML
    private BorderPane regPane;

    @FXML
    private Button save;

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
    private TextField pnText;

    private Stage _dialogStage;

    private MainFXApp mainFXApplication;

    public void setMainApp(MainFXApp mainFXApp) { mainFXApplication = mainFXApp; }

    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    @FXML
    private void initialize() {

    }

    @FXML
    private void handleSave() {
        //implement
        _dialogStage.close();
        mainFXApplication.goToReports();
    }

    @FXML
    private void handleCancel() {
        _dialogStage.close();
        mainFXApplication.goToHome();
    }
}


