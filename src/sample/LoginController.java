package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Mitchell on 9/28/2016.
 */
public class LoginController {
    @FXML
    private BorderPane loginPane;

    @FXML
    private TextField userText;

    @FXML
    private TextField passText;

    @FXML
    private Button cancel;

    private Stage _dialogStage;

    /** flag to signal whether dialog was closed normally */
    private boolean _okClicked = false;

    private MainFXApp mainFXAppApplication;

    public void setMainApp(MainFXApp mainFXApp) {
        mainFXAppApplication = mainFXApp;}

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return _okClicked;
    }

    @FXML
    private void handleOKPressed() {
        //First validate the data to ensure it is at least reasonable
        if (isInputValid()) {
            //if the data is reasonable, then remember the the student data in the window
            System.out.println("authenticated");
            //signal success and close this dialog window.
            _okClicked = true;
            _dialogStage.close();
            mainFXAppApplication.goToHome();
        } else {
            System.out.println(userText.getText());
        }
    }

//    @FXML
//    private void handleCancel() {
//        cancel.setOnAction(e -> {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScreen.fxml"));
//            try {
//                Parent root = (Parent) loader.load();
//                Scene scene = new Scene(root);
//                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//                stage.setScene(scene);
//                stage.show();
//            } catch (IOException ie) {
//                ie.printStackTrace();
//            }
//        });
//    }

    public BorderPane getLoginPane() {
        return loginPane;
    }

    private boolean isInputValid() {
        return userText.getText().equals("user") && passText.getText().equals("pass");
    }
}
