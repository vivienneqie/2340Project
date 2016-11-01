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

    /**
     * Method to start the main application
     * @param primaryStage Stage
     * @throws FileNotFoundException exception
     */
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        File file = new File("users.txt");
        if (file.exists()) {
            //Populates user database with all users who have registered before
            User.populateUserDB(file);
        }
        MapController mapController = new MapController(this, primaryStage);
        mainScreen = primaryStage;
        initRootLayout(mainScreen);
    }

    /**
     * Method to go to welcome screen
     */
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

    /**
     * Method to initialize the root layout of the main screen
     * @param mainScreen Stage
     */
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
            mainScreen.setTitle("WELCOME");

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            mainScreen.setScene(scene);
            mainScreen.show();


        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Method to go to login screen
     */
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

    /**
     * Method to go to the home screen
     */
    public void goToHome() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(sample.MainFXApp.class.getResource("HomeScreen.fxml"));
            BorderPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("HOME");
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

    /**
     * Method to go to the registration screen
     */
    public void goToRegistration() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(sample.MainFXApp.class.getResource("RegisterScreen.fxml"));
            BorderPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("REGISTER");
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

    /**
     * Method to go to the edit profile screen
     */
    public void goToEditProfile() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(sample.MainFXApp.class.getResource("EditProfileScreen.fxml"));
            BorderPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("EDIT PROFILE");
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

    /**
     * Method to go to the purity submission screen
     */
    public void goToPuritySubmission() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(sample.MainFXApp.class.getResource("PurityReportForm.fxml"));
            BorderPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("SUBMIT PURITY REPORT");
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            PurityReportController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            dialogStage.show();
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    /**
     * Method to go to the water availability submission screen
     */
    public void goToSubmission() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(sample.MainFXApp.class.getResource("AvailabilitySubmissionForm.fxml"));
            BorderPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("SUBMIT HERE!");
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

    /**
     * Method to go to the page to view reports
     */
    public void goToReports() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(sample.MainFXApp.class.getResource("AvailabilityReports.fxml"));
            BorderPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("WATER AVAILABILITY REPORTS");
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

    public void goToPurityReports() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(sample.MainFXApp.class.getResource("PurityReportsView.fxml"));
            BorderPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("WATER PURITY REPORTS");
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            PurityReportsViewController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            dialogStage.show();
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    /**
     * Method to go to the map view of water availability
     */
    public void goToMapView() {
        Stage dialogStage = new Stage();
        dialogStage.setTitle("MAP");
        dialogStage.initOwner(mainScreen);
        MapController mapController = new MapController(this, mainScreen);
        Stage mapStage = mapController.getStage();
//        if (bp.getScene() == null) {
//            Scene mapScene = new Scene(bp);
//            dialogStage.setScene(mapScene);
//        } else {
//            dialogStage.setScene(bp.getScene());
//        }
        mapStage.show();
    }

    /**
     * Main method
     * @param args arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    }
