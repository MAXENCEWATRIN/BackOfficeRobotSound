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

    public void edit(Preference preference) {
        entityManager.getEntityManagerFactory().getCache().evict(Musician.class, preference.getMusician().getIdMusician());
        entityManager.merge(preference);
    }

    public void delete(Preference preference) {
        entityManager.getEntityManagerFactory().getCache().evict(Musician.class, preference.getMusician().getIdMusician());
        entityManager.remove(entityManager.merge(preference));

    }

    public List<Preference> all() {
        Query query = entityManager.createQuery("SELECT p FROM Preference p");
        return query.getResultList();
    }

    public List<Preference> getByMusicianId(int idMusician) {
        entityManager.getEntityManagerFactory().getCache().evict(Musician.class, idMusician);
        Query query = entityManager.createQuery("SELECT p FROM Preference p WHERE p.musician.idMusician = :idMusician ORDER BY p.wording ASC");
        query.setParameter("idMusician", idMusician);
        query.getFlushMode();
        entityManager.flush();
        return query.getResultList();
    }

    public Preference getPreferenceById(int id) {
        return entityManager.find(Preference.class, id);
    }

}
