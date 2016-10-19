package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * Created by Vivienne on 10/17/2016.
 */
public class EditProfileController {
    @FXML
    private BorderPane regPane;

    @FXML
    private Button save;

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
    private TextField pnText;

    private Stage _dialogStage;

    private MainFXApp mainFXApplication;

    /**
     *
     * @param mainFXApp
     */
    public void setMainApp(MainFXApp mainFXApp) { mainFXApplication = mainFXApp; }

    /**
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    /**
     *
     */
    @FXML
    private void initialize() {

    }

    /**
     *
     */
    @FXML
    private void handleSave() {
        //implement

//        if (fnText.getText() != null) {
//            user.setFirstName(fnText.getText());
//            changed = true;
//        }
//        if (lnText.getText() != null) {
//            user.setLastName(lnText.getText());
//            changed = true;
//        }
//        if (emailText.getText() != null) {
//            user.setEmail(emailText.getText());
//            changed = true;
//        }
//        if (unText.getText() != null) {
//            user.setUsername(unText.getText());
//            changed = true;
//        }
//        if (pwText.getText() != null || pwcText.getText() != null) {
//            if (pwText.getText().equals(pwcText.getText())) {
//                user.setPassword(pwText.getText());
//                changed = true;
//            } else {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Error");
//                alert.setHeaderText("Passwords do not match.");
//                alert.setContentText("Password confirmation is not identical to your password.");
//                alert.showAndWait();
//            }
//        }
//        if (pnText.getText() != null) {
//            user.setPhoneNumber(pnText.getText());
//            changed = true;
//        }
//        if (changed) {
//            User.addToDatabase(user.getUsername(), user);
//        }
        Stage toast = new Stage();
        toast.initOwner(_dialogStage);
        toast.initStyle(StageStyle.TRANSPARENT); //???
        toast.setResizable(false);
        Text text = new Text("");
        text.setFont(Font.font("Helvetica", 40));
        text.setFill(Color.BLUE);
        StackPane root = new StackPane(text);
        root.setStyle("-fx-background-radius: 20; -fx-background-color: rgba(0, 0, 0, 0.2); -fx-padding: 50px;");
        text.setOpacity(0);
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        toast.setScene(scene);
        toast.show();
        Timeline fadeInTimeline = new Timeline();
        KeyFrame fadeInKey1 = new KeyFrame(Duration.millis(500), new KeyValue(toast.getScene().getRoot().opacityProperty(), 1));
        fadeInTimeline.getKeyFrames().add(fadeInKey1);
        fadeInTimeline.setOnFinished((ae) ->
        {
            new Thread(() -> {
                try
                {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Timeline fadeOutTimeline = new Timeline();
                KeyFrame fadeOutKey1 = new KeyFrame(Duration.millis(500), new KeyValue (toast.getScene().getRoot().opacityProperty(), 0));
                fadeOutTimeline.getKeyFrames().add(fadeOutKey1);
                fadeOutTimeline.setOnFinished((aeb) -> toast.close());
                fadeOutTimeline.play();
            }).start();
        });
        fadeInTimeline.play();

        _dialogStage.close();
        mainFXApplication.goToHome();
    }

    /**
     *
     */
    @FXML
    private void handleCancel() {
        _dialogStage.close();
        mainFXApplication.goToHome();
    }
}


