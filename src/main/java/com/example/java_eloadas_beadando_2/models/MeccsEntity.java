package com.example.java_eloadas_beadando_2.models;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "meccs", schema = "nezok")
public class MeccsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "datum")
    private String datum;
    @Basic
    @Column(name = "kezdes")
    private Time kezdes;
    @Basic
    @Column(name = "belepo")
    private int belepo;
    @Basic
    @Column(name = "tipus")
    private String tipus;

    public MeccsEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Time getKezdes() {
        return kezdes;
    }

    public void setKezdes(Time kezdes) {
        this.kezdes = kezdes;
    }

    public int getBelepo() {
        return belepo;
    }

    public void setBelepo(int belepo) {
        this.belepo = belepo;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

}
