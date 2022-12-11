package com.example.hastanesistemi;

public class Doktor {
    private int DoktorID;
    private String DoktorAdi;
    private String DoktorSoyadi;
    private int PoliklinikID;

    public Doktor() {
    }

    public Doktor(int doktorID, String doktorAdi, String doktorSoyadi, int poliklinikID) {
        DoktorID = doktorID;
        DoktorAdi = doktorAdi;
        DoktorSoyadi = doktorSoyadi;
        PoliklinikID = poliklinikID;
    }

    public int getDoktorID() {
        return DoktorID;
    }

    public void setDoktorID(int doktorID) {
        DoktorID = doktorID;
    }

    public String getDoktorAdi() {
        return DoktorAdi;
    }

    public void setDoktorAdi(String doktorAdi) {
        DoktorAdi = doktorAdi;
    }

    public String getDoktorSoyadi() {
        return DoktorSoyadi;
    }

    public void setDoktorSoyadi(String doktorSoyadi) {
        DoktorSoyadi = doktorSoyadi;
    }

    public int getPoliklinikID() {
        return PoliklinikID;
    }

    public void setPoliklinikID(int poliklinikID) {
        PoliklinikID = poliklinikID;
    }
}
