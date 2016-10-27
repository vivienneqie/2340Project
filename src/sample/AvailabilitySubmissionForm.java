package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Random;

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

    /**
     * Method to set the main applcation
     * @param mainFXApp MainFXApp
     */
    public void setMainApp(MainFXApp mainFXApp) { mainFXApplication = mainFXApp; }

    /**
     * MEthod to set the dialog stage
     * @param dialogStage Stage
     */
    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    /**
     * Method to initialize the view and combo boxes
     */
    @FXML
    private void initialize() {
        String[] waterTypes = {"Bottled", "Welled", "Steam", "Lake", "Spring", "Other"};
        ObservableList typeList = FXCollections.observableArrayList(waterTypes);
        typeBox.setItems(typeList);

        String[] condTypes = {"Waste", "Treatable - Muddy", "Treatable - Clear", "Potable"};
        ObservableList condList = FXCollections.observableArrayList(condTypes);
        condBox.setItems(condList);
    }

    /**
     * Method to handle actions when the submission button is pressed
     */
    @FXML
    private void handleSubmission() {
        //TODO: handle submission and verify fields here
        String locationName = locationText.getText();
        Random rand = new Random();
        int poop = rand.nextInt(20) - 10;
        double scaling = (double) poop / 100;
        int pee = rand.nextInt(20) - 10;
        double scale = (double) pee / 100;
        Location location = new Location(locationName, 33 + scaling, scale);
        String waterType = typeBox.getSelectionModel().getSelectedItem().toString();
        String conditionType = condBox.getSelectionModel().getSelectedItem().toString();
        Report report = new Report(location, waterType, conditionType);
        _dialogStage.close();
        mainFXApplication.goToReports();
    }

    /**
     * Method to handle actions when the cancel button is pressed
     */
    @FXML
    private void handleCancelReport() {
        _dialogStage.close();
        mainFXApplication.goToHome();
    }
}
