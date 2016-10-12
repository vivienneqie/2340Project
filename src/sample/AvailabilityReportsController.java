package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by Archie on 10/12/2016.
 */
public class AvailabilityReportsController {
    @FXML
    private BorderPane reportViewPane;

    @FXML
    private TableView availTable;

    @FXML
    private TableColumn locationColumn;

    @FXML
    private TableColumn typeColumn;

    @FXML
    private TableColumn condColumn;

    @FXML
    private Button reportButton;

    private Stage _dialogStage;

    private MainFXApp mainFXApplication;

    public void setMainApp(MainFXApp mainFXApp) { mainFXApplication = mainFXApp; }

    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    @FXML
    private void initialize() {
        //TODO: setup reports here? Maybe make a separate class for a report...
    }

    @FXML
    private void handleReportButton() {
        _dialogStage.close();
        mainFXApplication.goToSubmission();
    }
}
