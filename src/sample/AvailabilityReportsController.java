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

import java.sql.Connection;
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
        //TODO: figure out why data isn't showing up
        //source code: http://blog.ngopal.com.np/2011/10/19/dyanmic-tableview-data-from-database/comment-page-1/
        //skipped dynamically adding columns
        try {
            Statement stmt = rb.conn.createStatement();
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM AVAILABLE;" );
            while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i = 1 ; i <= rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);
            }
            availTable.setItems(data);
            rs.close();
            stmt.close();
            rb.conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}