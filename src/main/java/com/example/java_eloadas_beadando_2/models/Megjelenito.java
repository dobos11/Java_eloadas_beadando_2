package com.example.java_eloadas_beadando_2.models;

public class Megjelenito {
    private int id;
    private String nezoNev;
    private String meccsDatum;
    private String belepesIdopont;

    public Megjelenito() {
    }

    public Megjelenito(int id, String nezoNev, String meccsDatum, String belepesIdopont) {
        this.id = id;
        this.nezoNev = nezoNev;
        this.meccsDatum = meccsDatum;
        this.belepesIdopont = belepesIdopont;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNezoNev() {
        return nezoNev;
    }

    public void setNezoNev(String nezoNev) {
        this.nezoNev = nezoNev;
    }

    public String getMeccsDatum() {
        return meccsDatum;
    }

    public void setMeccsDatum(String meccsDatum) {
        this.meccsDatum = meccsDatum;
    }

    public String getBelepesIdopont() {
        return belepesIdopont;
    }

    public void setBelepesIdopont(String belepesIdopont) {
        this.belepesIdopont = belepesIdopont;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", nezoNev='" + nezoNev + '\'' +
                ", meccsDatum='" + meccsDatum + '\'' +
                ", belepesIdopont='" + belepesIdopont + '\'';
    }
}
