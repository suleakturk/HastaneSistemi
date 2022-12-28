package com.example.hastanesistemi;

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

public class RandevuSilmeEkraniController implements Initializable {
    DatabaseConnection connection = new DatabaseConnection();
    int tarihid;

    @FXML
    private TextField hastaTcTxt;

    @FXML
    private ComboBox<String> randevuSaatiCombobox;

    @FXML
    private Button randevuSilBtn;

    @FXML
    private ComboBox<String> randevuTarihiCombobox;

    public void showAlertWarn() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("UYARI");
        alert.setHeaderText("Lütfen tüm kutucukları doldurunuz!");
        alert.show();
    }

    public void showAlertInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("BİLGİ");
        alert.setHeaderText("Randevu silme işlemi başarıyla gerçekleşmiştir...");
        alert.show();
    }

    @FXML
    void onRandevuSilBtn(ActionEvent event) {
        if (hastaTcTxt.getText() == null || randevuTarihiCombobox.getValue() == null || randevuSaatiCombobox.getValue() == null){
            showAlertWarn();
        }
        else {
            String query1 = "select tarih.tarihid from tarih inner join randevu on randevu.tarihid = tarih.tarihid where randevusaati = ? and randevutarihi = ? and hastatc = ?";
            try {
                PreparedStatement pst = connection.getConnection().prepareStatement(query1);
                pst.setString(1, randevuSaatiCombobox.getValue());
                pst.setString(2, randevuTarihiCombobox.getValue());
                pst.setInt(3, Integer.parseInt(hastaTcTxt.getText()));
                ResultSet rs = pst.executeQuery();

                while (rs.next()){
                    tarihid = Integer.parseInt(rs.getString("tarihid"));
                    System.out.println(tarihid+" "+hastaTcTxt.getText()+" "+randevuSaatiCombobox.getValue());
                }
                pst.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

           //randevuyu silme işlemi
            String query = "update randevu set durum = ? where hastaTC = ? and tarihID = ?";
            try {
                PreparedStatement pst = connection.getConnection().prepareStatement(query);
                pst.setString(1, "I");
                pst.setInt(2, Integer.parseInt(hastaTcTxt.getText()));
                pst.setInt(3, tarihid);

                pst.executeUpdate();
                pst.close();
                showAlertInfo();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> tarihlerListesi = FXCollections.observableArrayList();
        tarihlerListesi.add("2023-01-02");
        tarihlerListesi.add("2023-01-03");
        tarihlerListesi.add("2023-01-04");
        tarihlerListesi.add("2023-01-05");
        tarihlerListesi.add("2023-01-06");
        randevuTarihiCombobox.setItems(tarihlerListesi);
    }

    @FXML
    void onRandevuSaatiCombobox(MouseEvent event) {
        ObservableList<String> saatlerListesi = FXCollections.observableArrayList();
        randevuSaatiCombobox.setItems(saatlerListesi);

        String query = "select randevuSaati from tarih inner join randevu on tarih.tarihID = randevu.tarihID " +
                "where randevuTarihi = ? and hastaTC = ? and durum = ?";
        try {
            PreparedStatement pst = connection.getConnection().prepareStatement(query);
            pst.setString(1,randevuTarihiCombobox.getValue());
            pst.setInt(2, Integer.parseInt(hastaTcTxt.getText()));
            pst.setString(3, "D");
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                if (!saatlerListesi.contains(rs.getString("randevuSaati"))){
                    saatlerListesi.add(rs.getString("randevuSaati"));
                }
            }
            pst.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
