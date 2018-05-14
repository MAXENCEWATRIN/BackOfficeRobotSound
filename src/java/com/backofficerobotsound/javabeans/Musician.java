/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backofficerobotsound.javabeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author maxence
 */
@Entity
public class Musician implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMusician;
    private String name;
    private boolean laser;
    private String image  = "";
    
    @OneToMany(mappedBy = "musician", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<Preference> preferences = new ArrayList<>();

    public Musician() {
    }

    public long getIdMusician() {
        return idMusician;
    }

    public void setIdMusician(long idMusician) {
        this.idMusician = idMusician;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLaser() {
        return laser;
    }

    public void setLaser(boolean laser) {
        this.laser = laser;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public List<Preference> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Preference> preferences) {
        this.preferences = preferences;
    }
 
}
