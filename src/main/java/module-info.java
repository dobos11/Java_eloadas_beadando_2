module com.example.java_eloadas_beadando_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java_eloadas_beadando_2 to javafx.fxml;
    exports com.example.java_eloadas_beadando_2;
}