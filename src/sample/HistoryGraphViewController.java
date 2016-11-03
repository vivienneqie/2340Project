package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    @FXML
    private RadioButton virusRadio;

    @FXML
    private RadioButton contaminantRadio;

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
        String locText = locationText.getText();
        String virText = ppmText.getText();
        //double virNum = Double.parseDouble(virText);
        String yrText = yearText.getText();
        ReportDatabase rb = new ReportDatabase();
        ArrayList ppmList = new ArrayList<>();
        ArrayList monthList = new ArrayList<>();
        String sql = "SELECT * FROM PURITY WHERE LOCATION = ?";
        int i = 0;
        try {
            PreparedStatement stmt = rb.conn.prepareStatement(sql);
            stmt.setString(1, locText);
           // stmt.setDouble(2, virNum);
            ResultSet rs = stmt.executeQuery();
            while (rs.next() != false) {
                String date = (String) rs.getObject("DATE");
                if (date.substring(0,4).equals(yrText)) {
                    ppmList.add(rs.getObject("VIRUS"));
                    monthList.add(date.substring(5,7));
                    i++;
                }
            }
            XYChart.Series series = new XYChart.Series();
            for (int a = 0; a < i; a++) {
                series.getData().add(new XYChart.Data<>(monthList.get(a), ppmList.get(a)));
            }
            graph.getData().add(series);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}