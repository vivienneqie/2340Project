package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brittany
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Clean Water Mapping");
        Text welcome = new Text("Welcome!");
        welcome.setFont(new Font(24));
        welcome.setTextAlignment(TextAlignment.CENTER);
        Pane somePane = new Pane();
        somePane.setMaxHeight(200);
        VBox makePretty = new VBox();
        makePretty.getChildren().add(welcome);
        makePretty.getChildren().add(somePane);

        GridPane gp = new GridPane();
        for (int i = 0; i < 3; i++) {
            ColumnConstraints column = new ColumnConstraints(100);
            gp.getColumnConstraints().add(column);
        }

        GridPane loginPane = new GridPane();
        for (int i = 0; i < 3; i++) {
            ColumnConstraints column = new ColumnConstraints(100);
            loginPane.getColumnConstraints().add(column);
        }

        GridPane loggedinPane = new GridPane();
        for (int i = 0; i < 3; i++) {
            ColumnConstraints column = new ColumnConstraints(100);
            loggedinPane.getColumnConstraints().add(column);
        }

        GridPane registration = new GridPane();
        for (int i = 0; i < 3; i++) {
            ColumnConstraints column = new ColumnConstraints(100);
            registration.getColumnConstraints().add(column);
        }

        //Scene home = new Scene(gp, gp.getWidth(), gp.getHeight());
        Scene home = new Scene(gp);
        Scene loginScreen = new Scene(loginPane);
        Scene in = new Scene(loggedinPane);
        Scene registrationScreen = new Scene(registration);

        Button login = new Button("Login");
        login.setMaxWidth(120);
        login.setOnAction(e-> {
            primaryStage.setScene(loginScreen);
        });
        Button register = new Button("Register");
        register.setMaxWidth(120);
        register.setOnAction(e-> {
            primaryStage.setScene(registrationScreen);
        });

        VBox buttons = new VBox();
        buttons.getChildren().add(login);
        buttons.getChildren().add(register);

//        VBox rightPanel = new VBox();
//        rightPanel.getChildren().add(register);

//        gp.setPadding(new Insets(30, 185, 30, 185));
        gp.add(makePretty, 1, 0);
        gp.add(buttons, 1, 1);

        Text loginTitle = new Text("Login");
        loginTitle.setFont(new Font(24));
        loginTitle.setTextAlignment(TextAlignment.CENTER);
        Button goHome = new Button("Home");
        goHome.setOnAction(e-> {
            primaryStage.setScene(home);
        });
        Label label = new Label(" ");
        Pane space = new Pane();
        space.minHeightProperty().bind(label.heightProperty());
        Pane space2 = new Pane();
        space2.minHeightProperty().bind(label.heightProperty());
        TextField userTF = new TextField();
        PasswordField passF = new PasswordField();
        Button letMeIn = new Button("Login");
        loginPane.add(loginTitle, 2, 0);
        loginPane.add(goHome, 0, 0);
        loginPane.add(space, 1, 1);
        loginPane.add(new Text("Username: "), 1, 2);
        loginPane.add(userTF, 2, 2);
        loginPane.add(new Text("Password: "), 1, 3);
        loginPane.add(passF, 2, 3);
        loginPane.add(space2, 2, 5);
        loginPane.add(letMeIn, 2, 4);
        for (int i = 0; i <= 4; i++) {
            RowConstraints row = new RowConstraints();
            ColumnConstraints col = new ColumnConstraints();
            row.setPrefHeight(50);
            col.setPrefWidth(50);
            loginPane.getRowConstraints().add(row);
            loginPane.getColumnConstraints().add(col);
        }

        Text signUp = new Text("Sign Up");
        signUp.setFont(new Font(24));
        signUp.setTextAlignment(TextAlignment.CENTER);
        Button homeButton = new Button("Home");
        homeButton.setOnAction(e-> {
            primaryStage.setScene(home);
        });
        Label label2 = new Label(" ");
        Pane spacelol = new Pane();
        spacelol.minHeightProperty().bind(label2.heightProperty());
        Pane space2lol = new Pane();
        space2lol.minHeightProperty().bind(label2.heightProperty());
        registration.add(homeButton, 0, 0);
        registration.add(signUp, 2, 0);
        registration.add(spacelol, 1, 1);
        TextField firstName = new TextField();
        TextField lastName = new TextField();
        TextField email = new TextField();
        TextField username = new TextField();
        PasswordField password = new PasswordField();
        PasswordField confirmPassword = new PasswordField();
        registration.add(new Text("First name:"), 1, 2);
        registration.add(firstName, 2, 2);
        registration.add(new Text("Last name:"), 1, 3);
        registration.add(lastName, 2, 3);
        registration.add(new Text("Email address:"), 1, 4);
        registration.add(email, 2, 4);
        registration.add(new Text("Username:"), 1, 5);
        registration.add(username, 2, 5);
        registration.add(new Text("Password:"), 1, 6);
        registration.add(password, 2, 6);
        registration.add(new Text("Confirm password:"), 1, 7);
        registration.add(confirmPassword, 2, 7);


        //Screen for authenticated user
        Text appTitle = new Text("Clean Water Crowdsourcing");
        appTitle.setTextAlignment(TextAlignment.CENTER);
        appTitle.setFont(new Font(24));
        Button logout = new Button("Logout");
        logout.setOnAction(e-> {
            primaryStage.setScene(loginScreen);
            userTF.clear();
            passF.clear();
        });
        loggedinPane.add(appTitle, 1, 0);
        loggedinPane.add(logout, 2, 3);
        for (int i = 0; i <= 4; i++) {
            RowConstraints row = new RowConstraints();
            ColumnConstraints col = new ColumnConstraints();
            row.setPrefHeight(50);
            col.setPrefWidth(50);
            loggedinPane.getRowConstraints().add(row);
            loggedinPane.getColumnConstraints().add(col);
        }

        //User credential data
        Map<String, User> users = new HashMap<>();
        //Hardcoded username and password for M4 checkpoint
        User harambe = new User("user", "pass", "dank@memes.com", "RIP", "Harambe");
        users.put("user", harambe);
        letMeIn.setOnAction(e-> {
            String checkUser = userTF.getText();
            String checkPW = passF.getText();
            if (users.get(checkUser) != null && checkPW.equals(users.get(checkUser).getPassword())) {
                primaryStage.setScene(in);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Login");
                alert.setHeaderText("Username and/or Password Not Found");
                alert.setContentText("Username and/or password was entered incorrectly.");
                alert.showAndWait();
            }
        });

//        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setScene(home);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
