package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Arshiya
 * @author Brittany
 * @author Mitchell
 * @author Vivienne
 */
public class MainFXApp extends Application {

    private BorderPane rootLayout;

    private Stage mainScreen;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        File file = new File("users.txt");
        if (file.exists()) {
            //Populates user database with all users who have registered before
            User.populateUserDB(file);
        }
        mainScreen = primaryStage;
        initRootLayout(mainScreen);
    }

    public void goToWelcome() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(sample.MainFXApp.class.getResource("WelcomeScreen.fxml"));
            BorderPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Welcome");
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            WelcomeController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            dialogStage.show();
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    private void initRootLayout(Stage mainScreen) {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(sample.MainFXApp.class.getResource("WelcomeScreen.fxml"));
            rootLayout = loader.load();
            Stage dialogStage = new Stage();

            // Give the controller access to the main app.
            WelcomeController controller = loader.getController();
            controller.setDialogStage(mainScreen);
            controller.setMainApp(this);

            // Set the MainFXApp App title
            mainScreen.setTitle("Welcome");

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            mainScreen.setScene(scene);
            mainScreen.show();


        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void goToLogin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(sample.MainFXApp.class.getResource("LoginScreen.fxml"));
            BorderPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("LOGIN");
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            LoginController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            dialogStage.show();
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    public void goToHome() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(sample.MainFXApp.class.getResource("HomeScreen.fxml"));
            BorderPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Home");
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            HomeController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            dialogStage.show();
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    public void goToRegistration() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(sample.MainFXApp.class.getResource("RegisterScreen.fxml"));
            BorderPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Register");
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            RegisterController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            dialogStage.show();
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    public void goToEditProfile() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(sample.MainFXApp.class.getResource("EditProfileScreen.fxml"));
            BorderPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Profile");
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            EditProfileController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToSubmission() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(sample.MainFXApp.class.getResource("AvailabilitySubmissionForm.fxml"));
            BorderPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Submit Here!");
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            AvailabilitySubmissionForm controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            dialogStage.show();
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    public void goToReports() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(sample.MainFXApp.class.getResource("AvailabilityReports.fxml"));
            BorderPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Water Availability Reports");
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            AvailabilityReportsController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            dialogStage.show();
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
