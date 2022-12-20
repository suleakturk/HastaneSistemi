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

public class HastaGirisEkraniController {

    @FXML
    private Button randevuAlBtn;

    @FXML
    private Button randevuGoruntuleBtn;

    @FXML
    void onRandevuAlBtn(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("randevuAlmaEkraniView.fxml")));
        stage.setTitle("Randevu Alma Ekranı");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void onRandevuGoruntuleBtn(ActionEvent event) {

    }

}