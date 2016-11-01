package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Vivienne on 10/31/2016.
 */
public class PurityReportsViewController {
    @FXML
    private BorderPane reportViewPane;

    @FXML
    private TableView purityTable;

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
        PurityDatabase pb = new PurityDatabase();
        displayAll(pb);
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
     * @param pb PurityDatabase
     */
    @FXML
    public ArrayList<ArrayList> displayAll(PurityDatabase pb) {
        ArrayList<ArrayList> list = new ArrayList<ArrayList>();
        try {
            Statement stmt = pb.conn.createStatement();
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM PURITY;" );
            for(int i = 1 ; i < rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                purityTable.getColumns().addAll(col);
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
            purityTable.setItems(data);
            int i = 1;
            for (ArrayList l : list) {
                l = new ArrayList(data.get(i));
                i++;
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return list;
    }
}
