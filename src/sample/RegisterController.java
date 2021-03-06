package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
 * @author Vivienne
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

    private static User newUser;

    private static File file = new File("users.txt");

    private Stage _dialogStage;


    /** flag to signal whether dialog was closed normally */
    private boolean _okClicked = false;

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
     * Method to initialize the view
     */
    @FXML
    private void initialize() {
        ObservableList aList = FXCollections.observableArrayList(AccountTypes.values());
        accBox.getItems().clear();
        accBox.setItems(aList);
    }

    /**
     * Method to handle actions when the register button is pressed
     * @throws FileNotFoundException exception
     */
    @FXML
    private void handleRegister() throws FileNotFoundException {
        if (fnText.getText().equals("") || lnText.getText().equals("") || unText.getText().equals("")
                || pwText.getText().equals("") || pwcText.getText().equals("") || emailText.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("One or more of the fields was not filled out correctly");
            alert.setContentText("Please enter values for all of the required fields.");
            alert.showAndWait();
        } else if (unText.getText().contains("$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Your username may not contain the $ symbol.");
            alert.setContentText("Please enter a different username.");
            alert.showAndWait();
        } else if (pwcText.getText().contains("$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Your password may not contain the $ symbol.");
            alert.setContentText("Please select a different password.");
            alert.showAndWait();
        } else {
            if (pwText.getText().equals(pwcText.getText())) {
                //Create a new user given input
                String accType = accBox.getSelectionModel().getSelectedItem().toString();
                AccountTypes accountType;
                switch (accType) {
                    case "USER": accountType = AccountTypes.USER;
                        break;
                    case "ADMIN": accountType = AccountTypes.ADMIN;
                        break;
                    case "WORKER": accountType = AccountTypes.WORKER;
                        break;
                    case "MANAGER": accountType = AccountTypes.MANAGER;
                        break;
                    default: accountType = null;
                        break;
                }
                newUser = new User(unText.getText(), pwText.getText(),
                        emailText.getText(), fnText.getText(), lnText.getText(), accountType);
                newUser.addToDatabase(newUser.getUsername(), newUser);
                Gson gson = new Gson();
                String jsonString = gson.toJson(newUser);
                try {
                    //Writes data to a .txt file
                    PrintWriter output = new PrintWriter(new FileOutputStream(file, true));
                    output.println(newUser.getUsername() + "$" + jsonString);
                    output.flush();
                    output.close();
                } catch (FileNotFoundException fnfe) {
                    fnfe.printStackTrace();
                }
                _dialogStage.close();
                mainFXApplication.goToLogin();
//                    FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
//                    try {
//                        Parent root = (Parent) loader.load();
//                        Scene scene = new Scene(root);
//                        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//                        stage.setScene(scene);
//                        stage.show();
//                    } catch (IOException ie) {
//                        ie.printStackTrace();
//                    }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Passwords do not match");
                alert.setContentText("Password confirmation is not identical to your password.");
                alert.showAndWait();
            }
        }
    }

    /**
     * Method to handle actions when the cancel button is pressed
     */
    @FXML
    private void handleCancel() {
        _dialogStage.close();
        mainFXApplication.goToLogin();
    }

    /**
     * Method to get the user
     * @return User
     */
    public User getUser() {
        //TODO: accountType
        newUser = new User(unText.getText(), pwText.getText(),
                emailText.getText(), fnText.getText(), lnText.getText(), AccountTypes.USER);
        return newUser;
    }

}