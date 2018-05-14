/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backofficerobotsound.javabeans;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author maxence
 */
@Entity
public class Preference implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPreference;
    private String wording;
    private int x;
    private int y;

//    @ManyToOne
//    @JoinColumn(name = "IDMUSICIAN")
//    private Musician musician;
    @ManyToOne
    private Musician musician = new Musician();

    public Preference() {
    }

    public long getIdPreference() {
        return idPreference;
    }

    public void setIdPreference(long idPreference) {
        this.idPreference = idPreference;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Musician getMusician() {
        return musician;
    }

    public void setMusician(Musician musician) {
        this.musician = musician;
    }

    @Override
    public String toString() {
        return "Preference{" + "idPreference=" + idPreference + ", wording=" + wording + ", x=" + x + ", y=" + y + ", musician=" + musician + '}';
    }

}
