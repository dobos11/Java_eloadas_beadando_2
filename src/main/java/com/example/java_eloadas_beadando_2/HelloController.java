package com.example.java_eloadas_beadando_2;

import com.example.java_eloadas_beadando_2.Adatbazismenu.AdatbazisMenu;
import com.example.java_eloadas_beadando_2.models.BelepesEntity;
import com.example.java_eloadas_beadando_2.models.MeccsEntity;
import com.example.java_eloadas_beadando_2.models.Megjelenito;
import com.example.java_eloadas_beadando_2.models.NezoEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloController {
    @FXML
    private BorderPane rootPane;
    private TableView tv1;
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void menuOlvasClick(ActionEvent actionEvent) throws IOException {
        tv1=new TableView();
        tv1.setVisible(true);
        tv1.setManaged(true);
        tv1.getColumns().removeAll(tv1.getColumns());
        TableColumn<Megjelenito,String> idCol=new TableColumn("Id");
        TableColumn<Megjelenito,String> meccsDatumCol=new TableColumn("Név");
        TableColumn<Megjelenito,String> nezoNevCol=new TableColumn("Dátum");
        TableColumn<Megjelenito,String> belepesIdopontCol=new TableColumn("Időpont");
        tv1.getColumns().addAll(idCol,meccsDatumCol,nezoNevCol,belepesIdopontCol);
        idCol.setCellValueFactory(new PropertyValueFactory("Id"));
        meccsDatumCol.setCellValueFactory(new PropertyValueFactory("meccsDatum"));
        nezoNevCol.setCellValueFactory(new PropertyValueFactory("nezoNev"));
        belepesIdopontCol.setCellValueFactory(new PropertyValueFactory("belepesIdopont"));
        tv1.getItems().clear();
        List<BelepesEntity> belepesek= AdatbazisMenu.ReadBelepes();
        List<MeccsEntity> meccsek=AdatbazisMenu.ReadMeccs();
        List<NezoEntity> nezok=AdatbazisMenu.ReadNezo();
        for(BelepesEntity belepes:belepesek){
            int id=belepes.getId();
            String datum="";
            for(MeccsEntity meccs:meccsek) {
                if (belepes.getMeccsid() == meccs.getId()) {
                    datum = meccs.getDatum();
                }
            }
            String nev="";
            for(NezoEntity nezo:nezok) {
                if (belepes.getNezoid() == nezo.getId()) {
                    nev = nezo.getNev();
                }
            }
            String idopont=belepes.getIdopont().toString();
            tv1.getItems().add(new Megjelenito(id,datum,nev,idopont));
        }
        rootPane.setCenter(tv1);
    }

    public void menuOlvas2Click(ActionEvent actionEvent) throws IOException {

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
        FXMLLoader fxmlLoader = FXMLLoader.load(getClass().getResource("update.fxml"));
    }


    public void DeleteClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = FXMLLoader.load(getClass().getResource("deletepage.fxml"));
    }

    public void bt1Click(ActionEvent actionEvent) {
    }
}