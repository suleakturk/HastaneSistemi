package com.example.hastanesistemi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AnaEkranController {

    @FXML
    private Tab doktorGirisEkraniBtn;

    @FXML
    private Tab bashekimGirisEkraniBtn;

    @FXML
    private TextField bAdiTxt;

    @FXML
    private Button bGirisYapBtn;

    @FXML
    private PasswordField bSifreTxt;

    @FXML
    private Button dGirisYapBtn;

    @FXML
    private TextField dKullancıAdiTxt;

    @FXML
    private PasswordField dSifreTxt;

    @FXML
    private Button hGirisYapButon;

    @FXML
    private Button hKayıtOlButon;

    @FXML
    private Tab hastaGirisEkraniButonu;

    @FXML
    private TextField hastaKimlikTxt;

    @FXML
    private PasswordField hastaSifreTxt;

    public void showAlertWarn() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("HATA");
        alert.setHeaderText("Yanlış kullanıcı adı ya da parola!\nTekrar deneyiniz...");
        alert.show();
    }

    @FXML
    void onBGirisYapBtn(ActionEvent event) throws IOException {
        if (Objects.equals(bAdiTxt.getText(), "bashekim") && Objects.equals(bSifreTxt.getText(), "123")){
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("bashekimGirisEkraniView.fxml")));
            stage.setTitle("Başhekim Giriş Ekranı");
            stage.setScene(new Scene(root));
            stage.show();
        }
        else {
            showAlertWarn();
        }
    }

    @FXML
    void onDGirisYapBtn(ActionEvent event) {

    }

    @FXML
    void onHGirisYapButon(ActionEvent event) {

    }

    @FXML
    void onHKayıtOlButon(ActionEvent event) {
        dKullancıAdiTxt.getText();
    }

}
