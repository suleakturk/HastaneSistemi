package com.example.hastanesistemi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class AnaEkranController {
    DatabaseConnection connection = new DatabaseConnection();

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
            Stage primaryStage = (Stage) bGirisYapBtn.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("bashekimGirisEkraniView.fxml"));
            primaryStage.getScene().setRoot(newRoot);
        }
        else {
            showAlertWarn();
        }
    }

    @FXML
    void onDGirisYapBtn(ActionEvent event) throws IOException, SQLException {
        String query = "select * from doktor where doktorAdi = ? and sifre = ?";
        PreparedStatement pst = connection.getConnection().prepareStatement(query);
        pst.setString(1, dKullancıAdiTxt.getText());
        pst.setString(2, dSifreTxt.getText());
        ResultSet rs = pst.executeQuery();

        if (rs.next()){
            Stage primaryStage = (Stage) dGirisYapBtn.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("doktorGirisEkraniView.fxml"));
            primaryStage.getScene().setRoot(newRoot);
        }
        else {
            showAlertWarn();
        }
    }

    @FXML
    void onHGirisYapButon(ActionEvent event) throws IOException, SQLException {
        String query = "select * from hasta where hastaTC = ? and sifre = ?";
        PreparedStatement pst = connection.getConnection().prepareStatement(query);
        pst.setInt(1, Integer.parseInt(hastaKimlikTxt.getText()));
        pst.setString(2, hastaSifreTxt.getText());
        ResultSet rs = pst.executeQuery();

        if (rs.next()){
            Stage primaryStage = (Stage) hGirisYapButon.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("hastaGirisEkraniView.fxml"));
            primaryStage.getScene().setRoot(newRoot);
        }
        else {
            showAlertWarn();
        }
    }

    @FXML
    void onHKayıtOlButon(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hastaKayitEkraniView.fxml")));
        stage.setTitle("Hasta Kayıt Ekranı");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
