/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backofficerobotsound.ejb;

import com.backofficerobotsound.javabeans.Musician;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author maxen
 */
@Stateless
public class MusicianEJB {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public MusicianEJB() {
    }

    //ajouter ET editer un musicien
    public void edit(Musician musician) {
        entityManager.merge(musician);
    }
   
      //supprimer 
     public void delete(Musician musician) {
        entityManager.remove(entityManager.merge(musician));
    }
    
    public List<Musician> all() {
         Query query = entityManager.createQuery("SELECT m FROM Musician m");
        return query.getResultList();
    } 
     
    //supprimer Rest
    public Musician getById(int idMusicien) {
        System.out.println(idMusicien);
        return entityManager.find(Musician.class, idMusicien);
    }
    
    
    
}
