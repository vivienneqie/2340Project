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

    @FXML
    private TextField locationText;

    @FXML
    private Button cancelReport;

    @FXML
    private Button submitReport;

    @FXML
    private TextField latitudeTF;

    @FXML
    private TextField longitudeTF;

    private Stage _dialogStage;

    private MainFXApp mainFXApplication;

    /**
     * Method to set the main application
     * @param mainFXApp MainFXApp
     */
    public void setMainApp(MainFXApp mainFXApp) { mainFXApplication = mainFXApp; }

    /**
     * Method to set the dialog stage
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
        double longitude;
        double latitude;
        if (isValidLatLong()) {
            longitude = Double.parseDouble(longitudeTF.getText());
            latitude = Double.parseDouble(latitudeTF.getText());
            Location location = new Location(locationName, longitude, latitude);
            String waterType = typeBox.getSelectionModel().getSelectedItem().toString();
            String conditionType = condBox.getSelectionModel().getSelectedItem().toString();
            Report report = new Report(location, waterType, conditionType);
            _dialogStage.close();
            mainFXApplication.goToReports();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Latitude and/or longitude values were not valid.");
            alert.setContentText("Please enter a valid set of coordinates.");
            alert.showAndWait();
        }
    }

    /**
     * Method to check whether coordinates entered are valid
     * @return boolean whether coordinates are valid
     */
    private boolean isValidLatLong() {
        try {
            double latitude = Double.parseDouble(latitudeTF.getText());
            double longitude = Double.parseDouble(longitudeTF.getText());
            return latitude >= -90 && latitude <= 90
                    && longitude >= -90 && longitude <=90;
        } catch (NumberFormatException e) {
            return false;
        }
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
