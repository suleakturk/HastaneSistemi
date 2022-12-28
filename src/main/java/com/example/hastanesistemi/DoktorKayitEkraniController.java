package com.example.hastanesistemi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class DoktorKayitEkraniController implements Initializable {
    DatabaseConnection connection = new DatabaseConnection();
    ObservableList<String> poliklinikler = FXCollections.observableArrayList();
    int poliklinikid;

    @FXML
    private Button DkaydetBtn;

    @FXML
    private TextField doktorAdiTxt;

    @FXML
    private TextField doktorSoyadiTxt;
    @FXML
    private PasswordField dSifreTxt;

    @FXML
    private ComboBox<String> poliklinikAdiComboBox;

    public void showAlertWarn() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("UYARI");
        alert.setHeaderText("Lütfen tüm kutucukları doldurunuz!");
        alert.show();
    }

    public void showAlertInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("BİLGİ");
        alert.setHeaderText("Yeni doktor ekleme işlemi başarıyla gerçekleşmiştir...");
        alert.show();
    }

    @FXML
    void onDkaydetBtn (ActionEvent action) {

        if (doktorAdiTxt.getText() == null || doktorSoyadiTxt.getText() == null || dSifreTxt.getText() == null
                || poliklinikAdiComboBox.getValue() == null) {
            showAlertWarn();
        } else {

            String query2 = "select poliklinikID from poliklinik where poliklinikAdi = ?";

            try {
                PreparedStatement pst = connection.getConnection().prepareStatement(query2);
                pst.setString(1,poliklinikAdiComboBox.getValue());
                ResultSet rs = pst.executeQuery();

                while (rs.next()){
                    poliklinikid = Integer.parseInt(rs.getString("poliklinikid"));
                }

                pst.close();
                rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            // doktor tablosuna ekleme işlemi
            String query0 = "insert into doktor(doktorAdi,doktorSoyadi,sifre,poliklinikID) VALUES (?,?,?,?)";
            try {
                PreparedStatement pst = connection.getConnection().prepareStatement(query0);
                pst.setString(1, doktorAdiTxt.getText());
                pst.setString(2, doktorSoyadiTxt.getText());
                pst.setString(3, dSifreTxt.getText());
                pst.setInt(4, poliklinikid);

                pst.executeUpdate();
                pst.close();
                DkaydetBtn.setDisable(true);
                showAlertInfo();
                System.out.println("Yeni hasta ekleme başarıyla sonuçlandı...");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        poliklinikAdiComboBox.setItems(poliklinikler);

        String query = "select poliklinikAdi from poliklinik";
        try {
            PreparedStatement pst = connection.getConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                if (!poliklinikler.contains(rs.getString("poliklinikAdi"))){
                    poliklinikler.add(rs.getString("poliklinikAdi"));
                }
            }
            pst.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}