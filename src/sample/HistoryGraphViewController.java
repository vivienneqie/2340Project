package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Mitchell
 * @author Vivienne
 */
public class HistoryGraphViewController {
    @FXML
    private Button search;

    @FXML
    private TextField locationText;

    @FXML
    private TextField ppmText;

    @FXML
    private TextField yearText;

    @FXML
    private LineChart graph;

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

    }

    /**
     * Method to handle actions when the logout button is pressed
     */
    @FXML
    public void handleCancel() {
        _dialogStage.close();
        mainFXAppApplication.goToHome();
    }

    /**
     * Method to handle actions when the logout button is pressed
     */
    @FXML
    public void handleSearch() {
        //TODO: when search button is pressed, display report history on graph
    }
}