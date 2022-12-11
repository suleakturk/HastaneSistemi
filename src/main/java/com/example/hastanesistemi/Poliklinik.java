package com.example.hastanesistemi;

public class Poliklinik {
    private int PoliklinikID;
    private String PoliklinikAdi;

    public Poliklinik() {
    }

    public Poliklinik(int poliklinikID, String poliklinikAdi) {
        PoliklinikID = poliklinikID;
        PoliklinikAdi = poliklinikAdi;
    }

    public int getPoliklinikID() {
        return PoliklinikID;
    }

    public void setPoliklinikID(int poliklinikID) {
        PoliklinikID = poliklinikID;
    }

    public String getPoliklinikAdi() {
        return PoliklinikAdi;
    }

    public void setPoliklinikAdi(String poliklinikAdi) {
        PoliklinikAdi = poliklinikAdi;
    }
}
