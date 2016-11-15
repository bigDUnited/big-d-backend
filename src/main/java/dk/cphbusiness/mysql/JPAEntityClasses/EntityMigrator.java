/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.mysql.JPAEntityClasses;

import java.sql.Array;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jdk.nashorn.internal.objects.NativeArray;

/**
 *
 * @author redrose
 */
public class EntityMigrator {

    public static void main(String[] args) {
        Location firstLoc = new Location("My first Location");
        Location secondLoc = new Location("My second Location");
        EntityMigrator em = new EntityMigrator();
        ArrayList<Object> mylist = new ArrayList<Object>();
        
        mylist.add(firstLoc);
        mylist.add(secondLoc);
        
        Journey firstJourney = new Journey(firstLoc,secondLoc);
        mylist.add(firstJourney);
        em.persist(mylist);
        
        
        System.exit(0);
    }

    public void persist(ArrayList<Object> objects) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("bigDPersistence");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            for(Object o: objects){
            em.persist(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }
}
