package com.example.java_eloadas_beadando_2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
    @FXML
    public Label welcomeText;

    MenuItem create;

    @FXML
    private Label welcomeText2;



    @FXML
    public void gombocska(ActionEvent actionEvent) throws IOException {
        System.out.println("Szia");
        Parent root = FXMLLoader.load(getClass().getResource("createpage.fxml"));
    }

    @FXML
    public void menuOlvasClick(ActionEvent actionEvent) {
    }

    @FXML
    public void menuOlvas2Click(ActionEvent actionEvent) {
    }

    @FXML
    public void menuÍrClick(ActionEvent actionEvent) {
    }

    @FXML
    public void menuModositClick(ActionEvent actionEvent) {
    }

    @FXML

    public void menuTorolClick(ActionEvent actionEvent) {
    }


    public void CreateClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = FXMLLoader.load(getClass().getResource("createpage.fxml"));
    }


    public void ReadClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = FXMLLoader.load(getClass().getResource("readpage.fxml"));
    }


    public void UpdateClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = FXMLLoader.load(getClass().getResource("update.fxml"));
    }


    public void DeleteClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = FXMLLoader.load(getClass().getResource("deletepage.fxml"));
    }

}
