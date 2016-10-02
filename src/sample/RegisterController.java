package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Mitchell on 10/1/2016.
 */
public class RegisterController {
    @FXML
    private TextField unText;

    @FXML
    private TextField fnText;

    @FXML
    private TextField pwText;

    @FXML
    private ComboBox accBox;

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
    private void handleRegister() {
        Actor newUser = new Actor(unText.getText(), pwText.getText(), fnText.getText(), (AccountTypes) accBox.getValue());
        System.out.println(newUser.getName());
    }

    @FXML
    private void handleCancel() {
        System.exit(0);
    }

}
