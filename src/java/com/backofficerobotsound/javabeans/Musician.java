/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backofficerobotsound.javabeans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author maxence
 */
@Entity
@XmlRootElement
public class Musician implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMusician;
    private String name;
    private boolean laser;
    private String image  = "";
    
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "musician",fetch = FetchType.EAGER)
    private List<Preference> preferences;

    public Musician() {
    }
    
    public int getIdMusician() {
        return idMusician;
    }

    public void setIdMusician(int idMusician) {
        this.idMusician = idMusician;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Preference> getPreferences() {
        return preferences;
    }

    public void setListePreferences(List<Preference> preferences) {
        this.preferences = preferences;
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
    
}
