/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.mysql.JPAEntityClasses;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author redrose
 */
public class EntityMigrator {

    public static void main(String[] args) {
        Location firstLoc = new Location("My first Location");
        Location secondLoc = new Location("My second Location");
        EntityMigrator em = new EntityMigrator();
        em.persist(firstLoc);
        em.persist(secondLoc);
        
        Journey firstJourney = new Journey(firstLoc,secondLoc);
        em.persist(firstJourney);
        System.exit(0);
    }

    public void persist(Object object) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("bigDPersistence");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
