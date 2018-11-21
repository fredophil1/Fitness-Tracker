package sample;

import database.DBLogic;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {

    private Stage primaryStage;

    //HGqCVfgwu8VB8pg4 freddi

    // private static final String USERNAME = "freddi";
    // private static final String PASSWORD = "";
    //  private static final String CONNECTOR = "jdbc:mysql://localhost/FitnessTrackerDB";

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        mainWindow();

    }

    public void mainWindow() {

        try {

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("sample.fxml"));
            StackPane pane = loader.load();

            primaryStage.setMinHeight(300);
            primaryStage.setMinWidth(100);

            Controller controller = loader.getController();
            controller.setMain(this);

            Scene scene = new Scene(pane);

            primaryStage.setScene(scene);

            primaryStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) throws SQLException {


        launch(args);


    }
}
