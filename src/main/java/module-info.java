module com.example.hastanesistemi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.hastanesistemi to javafx.fxml;
    exports com.example.hastanesistemi;
}