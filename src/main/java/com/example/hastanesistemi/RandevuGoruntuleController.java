package com.example.hastanesistemi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class RandevuGoruntuleController implements Initializable{
    ObservableList<Randevu> liste = FXCollections.observableArrayList();
    DatabaseConnection connection = new DatabaseConnection();

    @FXML
    private TextField doktorAdiTxt;

    @FXML
    private TextField doktorSoyadiTxt;

    @FXML
    private TableColumn<Randevu,Integer> hastaTC;

    @FXML
    private TableColumn<Randevu,String> randevuSaati;

    @FXML
    private TableView<Randevu> randevuTablosu;

    @FXML
    private TableColumn<Randevu,String> randevuTarihi;

    @FXML
    void onRandevularıAraBtn(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
