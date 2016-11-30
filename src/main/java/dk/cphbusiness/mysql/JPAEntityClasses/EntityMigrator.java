/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.mysql.JPAEntityClasses;

import java.sql.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jdk.nashorn.internal.objects.NativeArray;

/**
 *
 * @author redrose
 */
public class EntityMigrator {

    public static void main(String[] args) throws ParseException {
        Location firstLoc = new Location("My first Location");
        Location secondLoc = new Location("My second Location");
        EntityMigrator em = new EntityMigrator();
        ArrayList<Object> mylist = new ArrayList<Object>();

        mylist.add(firstLoc);
        mylist.add(secondLoc);

        FerryType ferryType = new FerryType("Big Ferry", 10, 20, false, 0, 0);
        mylist.add(ferryType);
        Ferry ferry = new Ferry(ferryType, "The beautiful one");
        mylist.add(ferry);

        Journey firstJourney = new Journey(firstLoc,secondLoc,ferry, new Date(12323));
        mylist.add(firstJourney);
        Vehicle car = new Vehicle("Car", 2);
        mylist.add(car);
        
        Reservation res = new Reservation("Raul","S",1,car,firstJourney);
        mylist.add(res);
        
        DateFormat time = new SimpleDateFormat("HH:mm:ss");
        Date date1 = time.parse("20:00:00");
        
        Schedule schedule1 = new Schedule("monday",date1);
        Schedule schedule2 = new Schedule("tuesday",date1);
        List listOfSchedules = new ArrayList();
        listOfSchedules.add(schedule1);
        listOfSchedules.add(schedule2);
        mylist.add(schedule1);
        mylist.add(schedule2);
        
        Route r1 = new Route("a lot", "More", listOfSchedules);
        
        mylist.add(r1);

        em.persist(mylist);

        System.exit(0);
    }

    public void persist(ArrayList<Object> objects) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("bigDPersistence");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            for (Object o : objects) {
                em.persist(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            System.exit(0);
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }
}
