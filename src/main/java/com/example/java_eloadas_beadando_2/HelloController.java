package com.example.java_eloadas_beadando_2;

import com.example.java_eloadas_beadando_2.Adatbazismenu.AdatbazisMenu;
import com.example.java_eloadas_beadando_2.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class HelloController {
    @FXML
    private BorderPane rootPane;
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void menuOlvasClick(ActionEvent actionEvent) throws IOException {
        TableView tv1=new TableView();
        tv1.setVisible(true);
        tv1.setManaged(true);
        tv1.getColumns().removeAll(tv1.getColumns());
        TableColumn<Megjelenito, String> idCol = new TableColumn("Id");
        TableColumn<Megjelenito, String> meccsDatumCol = new TableColumn("Név");
        TableColumn<Megjelenito, String> nezoNevCol = new TableColumn("Dátum");
        TableColumn<Megjelenito, String> belepesIdopontCol = new TableColumn("Időpont");
        tv1.getColumns().addAll(idCol, meccsDatumCol, nezoNevCol, belepesIdopontCol);
        idCol.setCellValueFactory(new PropertyValueFactory("Id"));
        meccsDatumCol.setCellValueFactory(new PropertyValueFactory("meccsDatum"));
        nezoNevCol.setCellValueFactory(new PropertyValueFactory("nezoNev"));
        belepesIdopontCol.setCellValueFactory(new PropertyValueFactory("belepesIdopont"));
        tv1.getItems().clear();
        List<BelepesEntity> belepesek = AdatbazisMenu.ReadBelepes();
        List<MeccsEntity> meccsek = AdatbazisMenu.ReadMeccs();
        List<NezoEntity> nezok = AdatbazisMenu.ReadNezo();
        for (BelepesEntity belepes : belepesek) {
            int id = belepes.getId();
            String datum = "";
            for (MeccsEntity meccs : meccsek) {
                if (belepes.getMeccsid() == meccs.getId()) {
                    datum = meccs.getDatum();
                }
            }
            String nev = "";
            for (NezoEntity nezo : nezok) {
                if (belepes.getNezoid() == nezo.getId()) {
                    nev = nezo.getNev();
                }
            }
            String idopont = belepes.getIdopont().toString();
            tv1.getItems().add(new Megjelenito(id, datum, nev, idopont));
        }
        rootPane.setCenter(tv1);
    }

    public void menuOlvas2Click(ActionEvent actionEvent) throws IOException {
        HBox hBox=new HBox();
        hBox.setPadding(new Insets(20,20,0,0));
        Label idLb=new Label();
        idLb.setText("Adjon meg egy ID-t:");
        ComboBox idCb=new ComboBox();
        List<BelepesEntity> belepesek= AdatbazisMenu.ReadBelepes();
        for(BelepesEntity belepes:belepesek)
            idCb.getItems().add(belepes.getId());
        Button keresBt=new Button();
        keresBt.setText("Keres");
        hBox.getChildren().add(idLb);
        hBox.getChildren().add(idCb);
        hBox.getChildren().add(keresBt);

        rootPane.setCenter(hBox);

    }

    public void menuÍrClick(ActionEvent actionEvent) {
    }

    public void menuModositClick(ActionEvent actionEvent) {
    }

    public void menuTorolClick(ActionEvent actionEvent) {
    }

    public void CreateClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = FXMLLoader.load(getClass().getResource("createpage.fxml"));

    }


    public void ReadClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = FXMLLoader.load(getClass().getResource("readpage.fxml"));
    }


    public void UpdateClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = FXMLLoader.load(getClass().getResource("updatepage.fxml"));
    }


    public void DeleteClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = FXMLLoader.load(getClass().getResource("deletepage.fxml"));
    }

    public void bt1Click(ActionEvent actionEvent) {
    }




}

