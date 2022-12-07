package com.example.java_eloadas_beadando_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Time;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AdatbazisMenu.CreateMeccs("2019.04.07",new Time(15,0,0),"bajnoki",500);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}