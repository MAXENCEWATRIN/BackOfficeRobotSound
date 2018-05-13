/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backofficerobotsound.ejb;

import com.backofficerobotsound.javabeans.Musician;
import com.backofficerobotsound.javabeans.Preference;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    public Preference getById(int id) {
        return entityManager.find(Preference.class, id);
    }

}
