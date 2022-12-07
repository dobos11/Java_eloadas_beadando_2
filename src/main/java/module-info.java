module com.example.java_eloadas_beadando_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    opens com.example.java_eloadas_beadando_2.models to org.hibernate.orm.core;
    opens com.example.java_eloadas_beadando_2 to javafx.fxml;
    exports com.example.java_eloadas_beadando_2;
    exports com.example.java_eloadas_beadando_2.models;
}