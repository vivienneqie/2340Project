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

    public void setMainApp(MainFXApp mainFXApp) { mainFXApplication = mainFXApp; }

    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    @FXML
    private void initialize() {
        //TODO: setup reports here? Maybe make a separate class for a report...
        ReportDatabase rb = new ReportDatabase();
        displayAll(rb);
    }

    @FXML
    private void handleHomeButton() {
        _dialogStage.close();
        mainFXApplication.goToHome();
    }

    @FXML
    public void displayAll(ReportDatabase rb) {
        try {
            Statement stmt = rb.conn.createStatement();
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM AVAILABLE;" );
            for(int i=1 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
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