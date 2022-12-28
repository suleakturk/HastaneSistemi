package com.example.hastanesistemi;

public class Randevu {
    public String hastaTC;
    public String doktorAdi;
    public String doktorSoyadi;
    public String randevuTarihi;
    public String randevuSaati;
    public String durum;

    public Randevu() {
    }

    public Randevu(String hastaTC, String doktorAdi, String doktorSoyadi, String randevuTarihi, String randevuSaati,String durum) {
        this.hastaTC = hastaTC;
        this.doktorAdi = doktorAdi;
        this.doktorSoyadi = doktorSoyadi;
        this.randevuTarihi = randevuTarihi;
        this.randevuSaati = randevuSaati;
        this.durum = durum;
    }

    public String getDoktorAdi() {
        return doktorAdi;
    }

    public void setDoktorAdi(String doktorAdi) {
        this.doktorAdi = doktorAdi;
    }

    public String getDoktorSoyadi() {
        return doktorSoyadi;
    }

    public void setDoktorSoyadi(String doktorSoyadi) {
        this.doktorSoyadi = doktorSoyadi;
    }

    public String getHastaTC() {
        return hastaTC;
    }

    public void setHastaTC(String hastaTC) {
        this.hastaTC = hastaTC;
    }

    public String getRandevuTarihi() {
        return randevuTarihi;
    }

    public void setRandevuTarihi(String randevuTarihi) {
        this.randevuTarihi = randevuTarihi;
    }

    public String getRandevuSaati() {
        return randevuSaati;
    }

    public void setRandevuSaati(String randevuSaati) {
        this.randevuSaati = randevuSaati;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
}
