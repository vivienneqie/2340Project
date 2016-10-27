package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Archie on 10/12/2016.
 */
public class AvailabilityReportsController {
    @FXML
    private BorderPane reportViewPane;

    @FXML
    private TableView availTable;

    @FXML
    private Button reportButton;

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
     * Method to initialize the database
     */
    @FXML
    private void initialize() {
        ReportDatabase rb = new ReportDatabase();
        displayAll(rb);
    }

    /**
     * Method to handle actions when home button is pressed
     */
    @FXML
    private void handleHomeButton() {
        _dialogStage.close();
        mainFXApplication.goToHome();
    }

    /**
     * Method to display all the elements in the database in a table
     * @param rb ReportDatabase
     */
    @FXML
    public void displayAll(ReportDatabase rb) {
        try {
            Statement stmt = rb.conn.createStatement();
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM AVAILABLE;" );
            for(int i = 1 ; i < rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                availTable.getColumns().addAll(col);
            }

            while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i = 1 ; i <= rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            availTable.setItems(data);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}