package com.example.java_eloadas_beadando_2.models;

import javax.persistence.*;
import org.hibernate.*;
import java.util.Objects;

@Entity
@Table(name = "nezo", schema = "nezok")
public class NezoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nev")
    private String nev;
    @Basic
    @Column(name = "ferfi")
    private byte ferfi=-1;
    @Basic
    @Column(name = "berletes")
    private byte berletes=-1;

    public NezoEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public byte getFerfi() {
        return ferfi;
    }

    public void setFerfi(byte ferfi) {
        this.ferfi = ferfi;
    }

    public byte getBerletes() {
        return berletes;
    }

    public void setBerletes(byte berletes) {
        this.berletes = berletes;
    }


}
