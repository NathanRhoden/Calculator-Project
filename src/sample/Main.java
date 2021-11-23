package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Parent root;


        try {
            root = FXMLLoader.load( getClass().getResource("Main.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setTitle("Calculator");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();



        } catch (IOException e) {
            e.printStackTrace();
        }














    }
}
