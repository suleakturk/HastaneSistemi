package com.example.hastanesistemi;

public class Randevu {
    private int RandevuID;
    Hasta hasta = new Hasta();
    Doktor doktor = new Doktor();
    Poliklinik poliklinik = new Poliklinik();
    public Randevu() {
    }

    public Randevu(int randevuID, Hasta hasta, Doktor doktor, Poliklinik poliklinik) {
        RandevuID = randevuID;
        this.hasta = hasta;
        this.doktor = doktor;
        this.poliklinik = poliklinik;
    }

    public int getRandevuID() {
        return RandevuID;
    }

    public void setRandevuID(int randevuID) {
        RandevuID = randevuID;
    }

    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public Poliklinik getPoliklinik() {
        return poliklinik;
    }

    public void setPoliklinik(Poliklinik poliklinik) {
        this.poliklinik = poliklinik;
    }
}
