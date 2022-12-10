package com.example.java_eloadas_beadando_2.models;

import com.example.java_eloadas_beadando_2.RestKliens;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




    public class RestCreate {
        private VBox tableHolder;
        private VBox container;
        private Label title;
        private Label taskDescription;

        private Label userNameErrorLabel = new Label();
        private Label userGenderErrorLabel = new Label();
        private Label userEmailErrorLabel = new Label();
        private Label userStatusErrorLabel = new Label();

        private VBox filterBox;

        public VBox getContainer() {return container;}

        public RestCreate(String title, String taskDescription){
            createFilterBox();

            this.title = new Label(title);
            this.title.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 25));
            this.title.setPadding(new Insets(10,0,10,20));

            Label taskTitle = new Label("Feladat:");
            taskTitle.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 14));
            taskTitle.setPadding(new Insets(0,0,5,20));

            this.taskDescription = new Label(taskDescription);
            this.taskDescription.setFont(Font.font("Helvetica", 12));
            this.taskDescription.setPadding(new Insets(0,0,20,20));


            this.tableHolder = new VBox();
            this.tableHolder.setAlignment(Pos.CENTER);
            this.container = new VBox();
            this.container.getChildren().addAll(this.title, taskTitle , this.taskDescription, this.filterBox);
        }

        public void createFilterBox(){
            Label mainTitle = new Label("POST kérés küldése:");
            Label description = new Label("A kérés elküdéséhez szükség van egy név, nem, email és státusz tulajdonság megadására. A lenti űrlapban töltheti ki az adatokat, amit küldeni szeretne!");
            Label mainTitle2 = new Label("Válasz a kérésre:");

            Label userNameLabel = new Label("*Adjon meg egy nevet:");
            Label userGenderLabel = new Label("*Adjon meg egy nemet");
            Label userEmailLabel = new Label("*Adjon meg egy email-t");
            Label userStatusLabel = new Label("*Adja meg a felhasználó státuszát");

            Label response = new Label();

            mainTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
            mainTitle2.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
            mainTitle2.setPadding(new Insets(10,0,0,0));

            userNameLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 10));
            userNameLabel.setPadding(new Insets(2,0,2,0));
            userNameErrorLabel.setTextFill(Color.RED);
            userNameErrorLabel.setPadding(new Insets(2,0,2,0));

            userGenderLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 10));
            userGenderLabel.setPadding(new Insets(2,0,2,0));
            userGenderErrorLabel.setTextFill(Color.RED);
            userGenderErrorLabel.setPadding(new Insets(2,0,2,0));

            userEmailLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 10));
            userEmailLabel.setPadding(new Insets(2,0,2,0));
            userEmailErrorLabel.setTextFill(Color.RED);
            userEmailErrorLabel.setPadding(new Insets(2,0,2,0));

            userStatusLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 10));
            userStatusLabel.setPadding(new Insets(2,0,2,0));
            userStatusErrorLabel.setTextFill(Color.RED);
            userStatusErrorLabel.setPadding(new Insets(2,0,2,0));

            ComboBox<String> genderComboBox = new ComboBox<>();
            genderComboBox.getItems().add("male");
            genderComboBox.getItems().add("female");

            ComboBox<String> statusComboBox = new ComboBox<>();
            statusComboBox.getItems().add("active");
            statusComboBox.getItems().add("inactive");

            VBox getRequestBox = new VBox();
            TextField userNameTextfield = new TextField();
            userNameTextfield.setMaxWidth(200);
            TextField userEmailTextfield = new TextField();
            userEmailTextfield.setMaxWidth(200);

            this.filterBox = new VBox();
            Button sendRequestButton = new Button("Kérés küldése");
            sendRequestButton.setOnAction(actionEvent -> {
                userNameErrorLabel.setText("");
                userGenderErrorLabel.setText("");
                userEmailErrorLabel.setText("");
                userStatusErrorLabel.setText("");

                Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
                Matcher matcher = pattern.matcher(userEmailTextfield.getText());
                System.out.println(matcher.matches());
                String userName = userNameTextfield.getText();
                String userEmail = userEmailTextfield.getText();
                if(userName == ""){
                    userNameErrorLabel.setText("A név mező nem lehet üres");
                }

                if (genderComboBox.getValue() == null) {
                    userGenderErrorLabel.setText("Kötelező a nemek listájából választani!");
                }

                if (!(matcher.matches())){
                    userEmailErrorLabel.setText("Az email mező nem lehet üres és valos emailnek kell lennie!");
                }

                if (statusComboBox.getValue() == null) {
                    userStatusErrorLabel.setText("Kötelező a státusz listájából választani!");
                }

                if(statusComboBox.getValue() != null && matcher.matches() && userName != "" && genderComboBox.getValue() != null){
                    try {
                        RestKliens.POST(userName,genderComboBox.getValue(),userEmail, statusComboBox.getValue());
                        response.setText("A kérés válasza: " + RestKliens.getGetResponseValue());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            filterBox.getChildren().addAll(mainTitle, description, userNameLabel, userNameTextfield, userNameErrorLabel, userGenderLabel,genderComboBox,userGenderErrorLabel,userEmailLabel, userEmailTextfield,userEmailErrorLabel,userStatusLabel,statusComboBox,userStatusErrorLabel,sendRequestButton, mainTitle2, response);
            filterBox.setPadding(new Insets(10,10,10,20));
            filterBox.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
            filterBox.setBorder(new Border((new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID, CornerRadii.EMPTY,BorderWidths.DEFAULT))));
        }
    }

