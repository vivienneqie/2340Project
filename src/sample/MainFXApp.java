package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFXApp extends Application {

    private BorderPane rootLayout;

    private Stage mainScreen;

    @Override
    public void start(Stage primaryStage) {
        mainScreen = primaryStage;
        initRootLayout(mainScreen);
    }

    private void initRootLayout(Stage mainScreen) {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(sample.MainFXApp.class.getResource("WelcomeScreen.fxml"));
            rootLayout = loader.load();

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

    public static void main(String[] args) {
        launch(args);
    }
}
