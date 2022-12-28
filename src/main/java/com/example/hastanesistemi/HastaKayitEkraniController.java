package com.example.hastanesistemi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HastaKayitEkraniController {
    DatabaseConnection connection = new DatabaseConnection();

    @FXML
    private TextField sifreTxt;

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

    public void showAlertInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("BİLGİ");
        alert.setHeaderText("Yeni hasta ekleme işlemi başarıyla gerçekleşmiştir...");
        alert.show();
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
            pst.setString(4,sifreTxt.getText());
            pst.setString(5, telefontxt.getText());

            pst.executeUpdate();
            pst.close();
            kaydetBtn.setDisable(true);
            showAlertInfo();
            System.out.println("Yeni hasta ekleme başarıyla sonuçlandı...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}