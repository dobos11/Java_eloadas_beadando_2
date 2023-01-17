module com.example.java_eloadas_beadando_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires antlr;
    requires com.google.gson;
    requires java.desktop;
    opens com.example.java_eloadas_beadando_2 to javafx.fxml;
    exports com.example.java_eloadas_beadando_2;
    exports com.example.java_eloadas_beadando_2.models;
    exports com.example.java_eloadas_beadando_2.Adatbazismenu;
    opens com.example.java_eloadas_beadando_2.Adatbazismenu to javafx.fxml;
    opens com.example.java_eloadas_beadando_2.models to javafx.fxml, org.hibernate.orm.core;
}