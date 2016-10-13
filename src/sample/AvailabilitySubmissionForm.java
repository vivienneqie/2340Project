package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.scene.control.*;

import java.util.ArrayList;

/**
 * Created by Archie on 10/12/2016.
 */
public class AvailabilitySubmissionForm {
    @FXML
    private BorderPane reportFormPane;

    @FXML
    private ComboBox typeBox;

    @FXML
    private ComboBox condBox;

    //TODO: change this to coordinates from Google Maps for extra cred
    @FXML
    private TextField locationText;

    @FXML
    private Button cancelReport;

    @FXML
    private Button submitReport;

    private Stage _dialogStage;

    private MainFXApp mainFXApplication;

    public void setMainApp(MainFXApp mainFXApp) { mainFXApplication = mainFXApp; }

    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    @FXML
    private void initialize() {
        String[] waterTypes = {"Bottled", "Welled", "Steam", "Lake", "Spring", "Other"};
        ObservableList typeList = FXCollections.observableArrayList(waterTypes);
        typeBox.setItems(typeList);

        String[] condTypes = {"Waste", "Treatable - Muddy", "Treatable - Clear", "Potable"};
        ObservableList condList = FXCollections.observableArrayList(condTypes);
        condBox.setItems(condList);
    }

    @FXML
    private void handleSubmission() {
        //TODO: handle submission and verify fields here
    }

    @FXML
    private void handleCancelReport() {
        _dialogStage.close();
        //TODO:set where this goes after report is canceled
    }
}
