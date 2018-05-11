/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backofficerobotsound.ejb;

import com.backofficerobotsound.javabeans.Musician;
import com.backofficerobotsound.javabeans.Preference;
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
public class PreferenceEJB {
    
    @PersistenceContext
    private EntityManager entityManager;

    public PreferenceEJB() {
    }
    
    public void edit(Preference preference){
        System.out.println("editPreferenceEJB");
        entityManager.getEntityManagerFactory().getCache().evict(Musician.class, preference.getMusician().getIdMusician());
        entityManager.merge(preference);        
    }
    
    public void delete(Preference preference){
        System.out.println("deletePreferenceEJB");
        entityManager.getEntityManagerFactory().getCache().evict(Musician.class, preference.getMusician().getIdMusician());
        entityManager.remove(entityManager.merge(preference));
        
    }
    
    public List<Preference> all() {
        System.out.println("allPreferenceEJB");
        Query query = entityManager.createQuery("SELECT p FROM Preference p");   
        return query.getResultList();
    }
    
     public List<Preference> getByMusicianId(int idMusician) {
        // reload musicien and all preference associate.
        entityManager.getEntityManagerFactory().getCache().evict(Musician.class,idMusician);
        Query query = entityManager.createQuery("SELECT listePreferences FROM Preference listePreferences WHERE listePreferences.musicien.idMusicien=:idMusicien ORDER BY listePreferences.libelle ASC");
        query.setParameter("idMusicien", idMusician);
        query.getFlushMode();
        entityManager.flush();
        return query.getResultList();
    }
     
     public Preference getPreferenceById(int id)
    {
        return entityManager.find(Preference.class, id);
    }
    
}
