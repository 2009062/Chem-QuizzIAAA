package com.example.internalassesmentchemquzier;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static int highScore = 0;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu-view.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Press");
        stage.setScene(scene);
        stage.show();
    }

    private static Scene scene;
    static void setRoot(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));
        scene.setRoot(fxmlLoader.load());
    }


    public static void main(String[] args) {
        launch();
    }
}