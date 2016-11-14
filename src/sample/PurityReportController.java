package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Random;

/**
 * @author Vivienne
 */
public class PurityReportController {
    @FXML
    private BorderPane reportFormPane;

    @FXML
    private ComboBox condBox;

    //TODO: change this to coordinates from Google Maps for extra cred
    @FXML
    private TextField locationText;

    @FXML
    private TextField virusText;

    @FXML
    private TextField contaminantText;

    @FXML
    private Button cancelReport;

    @FXML
    private Button submitReport;

    private Stage _dialogStage;

    private MainFXApp mainFXApplication;

    /**
     * Method to set the main application
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
        String[] waterTypes = {"Potable", "Treatable - Muddy", "Treatable - Clear", "Waste"};
        ObservableList typeList = FXCollections.observableArrayList(waterTypes);
        condBox.setItems(typeList);
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
        String conditionType = condBox.getSelectionModel().getSelectedItem().toString();
        double virusPPM = Double.parseDouble(virusText.getText());
        double contaminantPPM = Double.parseDouble(contaminantText.getText());
        PurityReport report = new PurityReport(location, conditionType, virusPPM, contaminantPPM);
        _dialogStage.close();
        mainFXApplication.goToPurityReports();
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
