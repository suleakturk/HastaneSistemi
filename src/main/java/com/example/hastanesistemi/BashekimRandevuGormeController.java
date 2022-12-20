package com.example.hastanesistemi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

public class BashekimRandevuGormeController {

    @FXML
    private TreeTableView<?> table;

    @FXML
    private TreeTableColumn<?, ?> doktorAdiSoyadiTxt;

    @FXML
    private TreeTableColumn<?, ?> poliklinikIDTxt;

    @FXML
    private TreeTableColumn<?, ?> randevuSaatiTxt;

    @FXML
    private TreeTableColumn<?, ?> randevuTarihiTxt;

    @FXML
    private Button sorgulaBtn;

    @FXML
    private TextField hastaTcTxt;


    @FXML
    void onSorgulaBtn(ActionEvent event) {

    }

}
