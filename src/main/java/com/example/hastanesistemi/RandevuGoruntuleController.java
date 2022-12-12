package com.example.hastanesistemi;


import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RandevuGoruntuleController {

    @FXML
    private TableColumn<?, ?> hastaAdi;

    @FXML
    private TableColumn<?, ?> hastaSoyadi;

    @FXML
    private TableColumn<?, ?> randevuSaati;

    @FXML
    private TableView<?> randevuTablosu;

    @FXML
    private TableColumn<?, ?> randevuTarihi;

}
