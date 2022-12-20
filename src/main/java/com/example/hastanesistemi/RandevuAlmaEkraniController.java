package com.example.hastanesistemi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RandevuAlmaEkraniController implements Initializable {
    DatabaseConnection connection = new DatabaseConnection();

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

    @FXML
    void onRandevuAlBtn(ActionEvent event) {

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
    void onSaatComboboxClick(MouseEvent event) {

    }

    @FXML
    void onTarihComboboxClick(MouseEvent event) {

    }
}

