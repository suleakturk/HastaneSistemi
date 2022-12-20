package com.example.hastanesistemi;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RandevuAlmaEkraniController implements Initializable {
    DatabaseConnection connection = new DatabaseConnection();
    int doktorid,poliklinikid,tarihid;

    @FXML
    private TextField hastaTcTxt;

    @FXML
    private ComboBox<String> doktorAdiCombobox;

    @FXML
    private ComboBox<String> poliklinikAdiCombobox;

    @FXML
    private Button randevuAlBtn;

    @FXML
    private ComboBox<String> saatCombobox;

    @FXML
    private ComboBox<String> tarihCombobox;

    public void showAlertWarn() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("UYARI");
        alert.setHeaderText("Lütfen tüm kutucukları doldurunuz!");
        alert.show();
    }

    public void showAlertInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("BİLGİ");
        alert.setHeaderText("Randevu alma işlemi başarıyla gerçekleşmiştir.");
        alert.show();
    }

    @FXML
    void onRandevuAlBtn(ActionEvent event) {
        if (poliklinikAdiCombobox.getValue() == null || doktorAdiCombobox.getValue() == null || tarihCombobox.getValue() == null
                || saatCombobox.getValue() == null || hastaTcTxt.getText() == null){
            showAlertWarn();
        }
        else {
            String query = "select doktorid,poliklinikid from doktor where doktoradi = ?";
            try {
                PreparedStatement pst = connection.getConnection().prepareStatement(query);
                pst.setString(1, doktorAdiCombobox.getValue());
                ResultSet rs = pst.executeQuery();

                while (rs.next()){
                    doktorid = Integer.parseInt(rs.getString("doktorid"));
                    poliklinikid = Integer.parseInt(rs.getString("poliklinikid"));
                }
                pst.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //randevu bilgilerini randevu tablosuna ekledik
            String query0 = "insert into tarih(randevutarihi, randevusaati, doktorid) VALUES (?,?,?)";
            try {
                PreparedStatement pst = connection.getConnection().prepareStatement(query0);
                pst.setString(1,tarihCombobox.getValue());
                pst.setString(2,saatCombobox.getValue());
                pst.setInt(3,doktorid);

                pst.executeUpdate();
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            String query1 = "select tarihid from tarih where randevutarihi = ? and randevusaati = ? and doktorid = ?";
            try {
                PreparedStatement pst = connection.getConnection().prepareStatement(query1);
                pst.setString(1, tarihCombobox.getValue());
                pst.setString(2, saatCombobox.getValue());
                pst.setInt(3, doktorid);
                ResultSet rs = pst.executeQuery();

                while (rs.next()){
                    tarihid = Integer.parseInt(rs.getString("tarihid"));
                    System.out.println(tarihid);
                }
                pst.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //randevuyu randevu tablosuna ekledik
            String query2 = "insert into randevu(doktorid, hastatc, poliklinikid, tarihid, durum) VALUES (?,?,?,?,?)";
            try {
                PreparedStatement pst = connection.getConnection().prepareStatement(query2);
                pst.setInt(1,doktorid);
                pst.setInt(2, Integer.parseInt(hastaTcTxt.getText()));
                pst.setInt(3,poliklinikid);
                pst.setInt(4,tarihid);
                pst.setString(5,"D");

                pst.executeUpdate();
                pst.close();

                randevuAlBtn.setDisable(true);
                showAlertInfo();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Konferans combobox icerigini ayarlar
        ObservableList<String> poliklinikler = FXCollections.observableArrayList();
        poliklinikAdiCombobox.setItems(poliklinikler);

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

    @FXML
    void onDoktorAdiComboboxClick(MouseEvent event) {
        ObservableList<String> doktorlar = FXCollections.observableArrayList();

        String query = "select doktorAdi from doktor left join poliklinik on doktor.poliklinikID = poliklinik.poliklinikID " +
                "where poliklinikAdi = ?";
        try {
            PreparedStatement pst = connection.getConnection().prepareStatement(query);
            pst.setString(1,poliklinikAdiCombobox.getValue());
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                if (!doktorlar.contains(rs.getString("doktorAdi"))){
                    doktorlar.add(rs.getString("doktorAdi"));
                }
                doktorAdiCombobox.setItems(doktorlar);
            }
            pst.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onTarihComboboxClick(MouseEvent event) {
        ObservableList<String> tarihler = FXCollections.observableArrayList();
        tarihler.add("2023-01-02");
        tarihler.add("2023-01-03");
        tarihler.add("2023-01-04");
        tarihler.add("2023-01-05");
        tarihler.add("2023-01-06");
        tarihCombobox.setItems(tarihler);
    }

    @FXML
    void onSaatComboboxClick(MouseEvent event) {
        ObservableList<String> saatler = FXCollections.observableArrayList();
        saatler.add("08:00:00");
        saatler.add("09:00:00");
        saatler.add("10:00:00");
        saatler.add("11:00:00");
        saatler.add("13:00:00");
        saatler.add("14:00:00");
        saatler.add("15:00:00");
        saatler.add("16:00:00");

        String query = "select randevusaati from tarih inner join doktor on doktor.doktorid = tarih.doktorid " +
                "where doktoradi = ? and randevutarihi = ?";
        try {
            PreparedStatement pst = connection.getConnection().prepareStatement(query);
            pst.setString(1,doktorAdiCombobox.getValue());
            pst.setString(2,tarihCombobox.getValue());
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                saatler.remove(rs.getString("randevuSaati"));
            }
            saatCombobox.setItems(saatler);

            pst.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

   /* String query = "select randevusaati from tarih inner join doktor on doktor.doktorid = tarih.doktorid " +
            "inner join poliklinik on doktor.doktorid = poliklinik.poliklinikid where poliklinikAdi = ? and doktoradi";*/