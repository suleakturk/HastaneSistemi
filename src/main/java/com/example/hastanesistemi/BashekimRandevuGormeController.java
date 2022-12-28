package com.example.hastanesistemi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BashekimRandevuGormeController implements Initializable {
    DatabaseConnection connection = new DatabaseConnection();
    ObservableList<Randevu> liste = FXCollections.observableArrayList();

    @FXML
    private TableView<Randevu> table;

    @FXML
    private TableColumn<Randevu,String> doktorAdiTxt;

    @FXML
    private TableColumn<Randevu,String> durumTxt;

    @FXML
    private TableColumn<Randevu,String> doktorSoyadiTxt;

    @FXML
    private TableColumn<Randevu,String> hastaTcTxt;

    @FXML
    private TableColumn<Randevu,String> randevuSaatiTxt;

    @FXML
    private TableColumn<Randevu,String> randevuTarihiTxt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            String query = "select hastaTC,doktorAdi,doktorSoyadi,randevuTarihi,randevusaati,durum from tarih " +
                    "inner join doktor on doktor.doktorid = tarih.doktorid inner join randevu on doktor.doktorid = randevu.doktorid ";
            ResultSet resultSet = connection.getConnection().createStatement().executeQuery(query);

            while (resultSet.next()){
                liste.add(new Randevu(resultSet.getString("hastaTC"),
                        resultSet.getString("doktorAdi"), resultSet.getString("doktorSoyadi"), resultSet.getString("randevuTarihi"),
                        resultSet.getString("randevuSaati"),resultSet.getString("durum")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        hastaTcTxt.setCellValueFactory(new PropertyValueFactory<>("hastaTC"));
        doktorAdiTxt.setCellValueFactory(new PropertyValueFactory<>("doktorAdi"));
        doktorSoyadiTxt.setCellValueFactory(new PropertyValueFactory<>("doktorSoyadi"));
        randevuTarihiTxt.setCellValueFactory(new PropertyValueFactory<>("randevuTarihi"));
        randevuSaatiTxt.setCellValueFactory(new PropertyValueFactory<>("randevuSaati"));
        durumTxt.setCellValueFactory(new PropertyValueFactory<>("durum"));

        table.setItems(liste);
    }

}
