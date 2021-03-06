package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        mainWindow();

    }

    public void mainWindow() {

        try {

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/sample/sample.fxml"));
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
