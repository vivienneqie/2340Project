package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

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

        Button login = new Button("Login");
        login.setMaxWidth(120);
        Button register = new Button("Register");
        register.setMaxWidth(120);

        GridPane gp = new GridPane();
        for (int i = 0; i < 3; i++) {
            ColumnConstraints column = new ColumnConstraints(100);
            gp.getColumnConstraints().add(column);
        }
        VBox buttons = new VBox();
        buttons.getChildren().add(login);
        buttons.getChildren().add(register);

//        VBox rightPanel = new VBox();
//        rightPanel.getChildren().add(register);

//        gp.setPadding(new Insets(30, 185, 30, 185));
        gp.add(makePretty, 1, 0);
        gp.add(buttons, 1, 1);


//        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setScene(new Scene(gp, gp.getWidth(), gp.getHeight()));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
