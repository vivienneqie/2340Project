package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;


/**
 * @author Arshiya
 * @author Brittany
 * @author Mitchell
 */
public class RegisterController {
    @FXML
    private BorderPane regPane;

    @FXML
    private TextField fnText;

    @FXML
    private TextField lnText;

    @FXML
    private TextField emailText;

    @FXML
    private TextField unText;

    @FXML
    private TextField pwText;

    @FXML
    private TextField pwcText;

    @FXML
    private ComboBox accBox;

    @FXML
    private Button register;

    private Gson gson;

    private static File file = new File("users.txt");

    private Stage _dialogStage;

    /** flag to signal whether dialog was closed normally */
    private boolean _okClicked = false;

    private MainFXApp mainFXApplication;

    public void setMainApp(MainFXApp mainFXApp) { mainFXApplication = mainFXApp; }

    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    @FXML
    private void initialize() {
        ObservableList aList = FXCollections.observableArrayList(AccountTypes.values());
        accBox.getItems().clear();
        accBox.setItems(aList);
    }

    @FXML
    private void handleRegister() throws FileNotFoundException {
        
    }

    @FXML
    private void handleCancel() {
        _dialogStage.close();
        mainFXApplication.goToLogin();
    }

}