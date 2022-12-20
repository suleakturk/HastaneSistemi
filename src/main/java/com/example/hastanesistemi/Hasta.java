package com.example.hastanesistemi;

public class Hasta {
    private int HastaTC;
    private String HastaAdi;
    private String HastaSoyadi;
    private int Telefon;
    private String adres;
    private enum Cinsiyet {Kadin,Erkek};

    public Hasta() {
    }

    public Hasta(int hastaTC) {
        HastaTC = hastaTC;
    }

    public int getHastaTC() {
        return HastaTC;
    }

    public void setHastaTC(int hastaTC) {
        HastaTC = hastaTC;
    }

    public String getHastaAdi() {
        return HastaAdi;
    }

    public void setHastaAdi(String hastaAdi) {
        HastaAdi = hastaAdi;
    }

    public String getHastaSoyadi() {
        return HastaSoyadi;
    }

    public void setHastaSoyadi(String hastaSoyadi) {
        HastaSoyadi = hastaSoyadi;
    }

    public int getTelefon() {
        return Telefon;
    }

    public void setTelefon(int telefon) {
        Telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
