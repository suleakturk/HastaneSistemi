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

public class DoktorGirisEkraniController {

    @FXML
    private Button randevuGoruntuleBtn;

    @FXML
    private Button receteYazBtn;

    @FXML
    void onRandevuGoruntuleBtn(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("randevuGoruntuleView.fxml")));
        stage.setTitle("Randevularım");
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    void onReceteYazBtn(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("receteYazView.fxml")));
        stage.setTitle("Reçete Yazma Ekranı");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
