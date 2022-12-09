package com.example.java_eloadas_beadando_2;

import com.example.java_eloadas_beadando_2.models.RestCreate;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    public Label welcomeText;

    @FXML
    private Label welcomeText2;


    public void gombocska(ActionEvent actionEvent) {
        System.out.println("Szia");
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

    public void CreateClick(ActionEvent actionEvent) {

    }
    public void ReadClick(ActionEvent actionEvent)
    {

    }

    public void UpdateClick(ActionEvent actionEvent) {
    }

    public void DeleteClick(ActionEvent actionEvent) {
    }

    public void make() {
        Thread taskThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                for (int i = 0; i < 10; i++) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    progress += 1;
                    String thread = "FirstThread" + progress;

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            welcomeText.setText(thread);
                        }
                    });
                }
            }
        });

        Thread taskThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                for (int i = 0; i < 10; i++) {

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    progress += 1;
                    String thread = "FirstThread" + progress;

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                           welcomeText2.setText(thread);
                        }
                    });
                }
            }
        });

        taskThread.start();
        taskThread2.start();
    }



}
