package com.example.hastanesistemi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HastaKayitEkraniController {
    DatabaseConnection connection = new DatabaseConnection();

    @FXML
    private TextArea adresTxt;

    @FXML
    private ComboBox<?> cinsiyetBox;

    @FXML
    private TextField hastaAdiTxt;

    @FXML
    private TextField hastaSoyadiTxt;

    @FXML
    private TextField hastaTCtxt;

    @FXML
    private Button kaydetBtn;

    @FXML
    private TextField telefontxt;

    @FXML
    void onCinsiyetBox(ActionEvent event) {

    }

    @FXML
    void onKaydetBtn(ActionEvent event) {
        connection.getConnection();

        String query = "insert into hasta(hastaTC, hastaAdi, hastaSoyadi, sifre, telefon) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.getConnection().prepareStatement(query);
            pst.setInt(1, Integer.parseInt(hastaTCtxt.getText()));
            pst.setString(2,hastaAdiTxt.getText());
            pst.setString(3,hastaSoyadiTxt.getText());
            pst.setString(4,"546");
            pst.setString(5, telefontxt.getText());

            pst.executeUpdate();
            pst.close();
            System.out.println("ekleme başarıyla sonuçlandı");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}