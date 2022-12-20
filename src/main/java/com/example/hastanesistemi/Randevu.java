package com.example.hastanesistemi;

public class Randevu {
    public String hastaTC;
    public String randevuTarihi;
    public String randevuSaati;

    public Randevu() {
    }

    public Randevu(String hastaTC, String randevuTarihi, String randevuSaati) {
        this.hastaTC = hastaTC;
        this.randevuTarihi = randevuTarihi;
        this.randevuSaati = randevuSaati;
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
}
