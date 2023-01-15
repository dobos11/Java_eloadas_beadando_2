package com.example.java_eloadas_beadando_2.models;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "belepes", schema = "nezok")
public class BelepesEntity {
    @Basic
    @Column(name = "nezoid")
    private int nezoid;
    @Basic
    @Column(name = "meccsid")
    private int meccsid;
    @Basic
    @Column(name = "idopont")
    private Time idopont;
    @Id
    @Basic
    @Column(name = "id")
    private int id;

    public BelepesEntity() {
    }

    public int getNezoid() {
        return nezoid;
    }

    public void setNezoid(int nezoid) {
        this.nezoid = nezoid;
    }

    public int getMeccsid() { return meccsid; }

    public void setMeccsid(int meccsid) {
        this.meccsid = meccsid;
    }

    public Time getIdopont() {
        return idopont;
    }

    public void setIdopont(Time idopont) {
        this.idopont = idopont;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
