package com.example.java_eloadas_beadando_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void menuOlvasClick(ActionEvent actionEvent) {
    }

    public void menuOlvas2Click(ActionEvent actionEvent) {
    }

    public void menuÍrClick(ActionEvent actionEvent) {
    }

    public void menuModositClick(ActionEvent actionEvent) {
    }

    public void menuTorolClick(ActionEvent actionEvent) {
    }
}