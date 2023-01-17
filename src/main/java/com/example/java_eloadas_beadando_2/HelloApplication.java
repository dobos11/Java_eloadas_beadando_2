package com.example.java_eloadas_beadando_2;

import com.example.java_eloadas_beadando_2.models.MeccsEntity;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Time;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setMinWidth(480);
        stage.setMinHeight(720);
        stage.show();

    }

    public static void main(String[] args) throws IOException{
        launch();
    }
}