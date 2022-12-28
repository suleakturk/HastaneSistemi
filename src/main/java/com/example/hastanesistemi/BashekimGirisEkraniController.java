package com.example.hastanesistemi;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class BashekimGirisEkraniController {

    @FXML
    private Button randevuGörmeBtn;

    @FXML
    private Button yeniDoktorKaydiBtn;

    @FXML
    void onRandevuGörmeBtn(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("bashekimRandevuGormeView.fxml")));
        stage.setTitle("Randevu Görüntüleme Ekranı");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void onYeniDoktorKaydiBtn(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("doktorKayitEkraniView.fxml")));
        stage.setTitle("Doktor Kayıt Ekranı");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
