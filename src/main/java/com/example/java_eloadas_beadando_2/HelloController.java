package com.example.java_eloadas_beadando_2;

import com.example.java_eloadas_beadando_2.Adatbazismenu.AdatbazisMenu;
import com.example.java_eloadas_beadando_2.models.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Time;
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
        hBox.setPadding(new Insets(20,20,20,20));
        Label idLb=new Label();
        idLb.setText("Adjon meg egy ID-t:");
        ComboBox<Integer> idCb=new ComboBox();
        List<BelepesEntity> belepesek = AdatbazisMenu.ReadBelepes();
        for(BelepesEntity belepes:belepesek)
            idCb.getItems().add(belepes.getId());
        Button keresBt=new Button();
        keresBt.setText("Keres");
        hBox.getChildren().add(idLb);
        hBox.getChildren().add(idCb);
        hBox.getChildren().add(keresBt);
        keresBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               Label olvas2Lb=new Label();

               AdatbazisMenu.ReadBelepesById(idCb.getValue());
               BelepesEntity belepes=AdatbazisMenu.ReadBelepesById(idCb.getValue());

               String datum=AdatbazisMenu.ReadMeccsById(belepes.getMeccsid()).getDatum();
               String nev=AdatbazisMenu.ReadNezoById(belepes.getNezoid()).getNev();
               String idopont=belepes.getIdopont().toString();
               int id= belepes.getId();
               Megjelenito megjelenito=new Megjelenito(id,nev,datum,idopont);
               olvas2Lb.setText(megjelenito.toString());
               rootPane.setCenter(olvas2Lb);
            }
        });
        rootPane.setCenter(hBox);

    }

    public void menuÍrClick(ActionEvent actionEvent) {
        VBox vBox=new VBox();
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.setSpacing(20);

        Label ujBelepesLabel=new Label("Új Belépés hozzáadása");

        HBox meccshBox=new HBox();
        Label meccsLabel=new Label("Válasszon meccs Id-t");
        ComboBox<Integer> meccsCombobox=new ComboBox();
        List<MeccsEntity> meccsek = AdatbazisMenu.ReadMeccs();
        for(MeccsEntity meccs:meccsek)
            meccsCombobox.getItems().add(meccs.getId());
        meccshBox.setSpacing(20);
        meccshBox.getChildren().addAll(meccsLabel,meccsCombobox);

        HBox nezoHBox=new HBox();
        Label nezolabel=new Label("Vállasszon egy elemet");
        ComboBox<Integer> nezoCombobox=new ComboBox();
        List<NezoEntity> nezok = AdatbazisMenu.ReadNezo();
        for(NezoEntity nezo:nezok)
            nezoCombobox.getItems().add(nezo.getId());
        nezoHBox.setSpacing(20);
        nezoHBox.getChildren().addAll(nezolabel,nezoCombobox);

        HBox belepesHBox=new HBox();
        Label belepesLabel=new Label("Adja meg a belépés időőpontját (hh:mm:ss)");
        ComboBox<Integer> oraCombobox=new ComboBox();
        ComboBox<Integer> percCombobox=new ComboBox();
        ComboBox<Integer> masodpercCombobox=new ComboBox();
        for (int i=0;i<=23;i++)
            oraCombobox.getItems().add(i);
        for (int i=0;i<=59;i++)
            percCombobox.getItems().add(i);
        for (int i=0;i<=59;i++)
            masodpercCombobox.getItems().add(i);
        belepesHBox.setSpacing(20);
        belepesHBox.getChildren().addAll(belepesLabel,oraCombobox,percCombobox,masodpercCombobox);

        Button kuldButton = new Button("Küldés");
        kuldButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            AdatbazisMenu.CreateBelepes(nezoCombobox.getValue(),meccsCombobox.getValue(),new Time(oraCombobox.getValue(),percCombobox.getValue(),masodpercCombobox.getValue()));
            }
        });
        vBox.getChildren().addAll(ujBelepesLabel,meccshBox,nezoHBox,belepesHBox,kuldButton);
        rootPane.setCenter(vBox);

    }

    public void menuModositClick(ActionEvent actionEvent) {
        VBox vBox=new VBox();
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.setSpacing(20);

        Label ujBelepesLabel=new Label("Belépés módosítása");

        HBox idHBox=new HBox();
        Label idLabel=new Label("Válassza ki a módosítandó elem ID-jét");
        ComboBox<Integer> idCombobox=new ComboBox();
        List<BelepesEntity> belepesek = AdatbazisMenu.ReadBelepes();
        for(BelepesEntity belepes:belepesek)
            idCombobox.getItems().add(belepes.getId());
        idHBox.setSpacing(20);
        idHBox.getChildren().addAll(idLabel,idCombobox);

        HBox meccshBox=new HBox();
        Label meccsLabel=new Label("Válasszon meccs Id-t");
        ComboBox<Integer> meccsCombobox=new ComboBox();
        List<MeccsEntity> meccsek = AdatbazisMenu.ReadMeccs();
        for(MeccsEntity meccs:meccsek)
            meccsCombobox.getItems().add(meccs.getId());
        meccshBox.setSpacing(20);
        meccshBox.getChildren().addAll(meccsLabel,meccsCombobox);

        HBox nezoHBox=new HBox();
        Label nezolabel=new Label("Vállasszon egy elemet");
        ComboBox<Integer> nezoCombobox=new ComboBox();
        List<NezoEntity> nezok = AdatbazisMenu.ReadNezo();
        for(NezoEntity nezo:nezok)
            nezoCombobox.getItems().add(nezo.getId());
        nezoHBox.setSpacing(20);
        nezoHBox.getChildren().addAll(nezolabel,nezoCombobox);

        HBox belepesHBox=new HBox();
        Label belepesLabel=new Label("Adja meg a belépés időőpontját (hh:mm:ss)");
        ComboBox<Integer> oraCombobox=new ComboBox();
        ComboBox<Integer> percCombobox=new ComboBox();
        ComboBox<Integer> masodpercCombobox=new ComboBox();
        for (int i=0;i<=23;i++)
            oraCombobox.getItems().add(i);
        for (int i=0;i<=59;i++)
            percCombobox.getItems().add(i);
        for (int i=0;i<=59;i++)
            masodpercCombobox.getItems().add(i);
        belepesHBox.setSpacing(20);
        belepesHBox.getChildren().addAll(belepesLabel,oraCombobox,percCombobox,masodpercCombobox);

        Button kuldButton = new Button("Küldés");
        kuldButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BelepesEntity belepes=new BelepesEntity();
                belepes.setId(idCombobox.getValue());
                if(meccsCombobox.getValue()!=null)
                    belepes.setMeccsid(meccsCombobox.getValue());
                if(nezoCombobox.getValue()!=null)
                    belepes.setNezoid(nezoCombobox.getValue());
                if(oraCombobox.getValue()!=null && percCombobox.getValue()!=null && masodpercCombobox.getValue()!=null)
                    belepes.setIdopont(new Time(oraCombobox.getValue(),percCombobox.getValue(),masodpercCombobox.getValue()));
                AdatbazisMenu.UpdateBelepes(belepes);
            }
        });
        vBox.getChildren().addAll(ujBelepesLabel,idHBox,meccshBox,nezoHBox,belepesHBox,kuldButton);
        rootPane.setCenter(vBox);

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

