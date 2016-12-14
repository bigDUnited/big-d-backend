
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.mysql.JPAEntityClasses;

import dtos.JourneysDTO;
import dtos.LocationDTO;
import java.sql.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jdk.nashorn.internal.objects.NativeArray;

/**
 *
 * @author redrose
 */
public class EntityMigrator {

    public static void main(String[] args) throws ParseException { 
        
          EntityMigrator em = new EntityMigrator();
//        ArrayList<Object> mylist = new ArrayList<Object>();
//        DateFormat time = new SimpleDateFormat("HH:mm:ss");
//        Date date1 = time.parse("20:00:00");
//        Date date2 = time.parse("10:00:00");
//
//        Schedule schedule1 = new Schedule("monday", date1);
//        Schedule schedule2 = new Schedule("monday", date2);
//        Schedule schedule3 = new Schedule("tuesday", date1);
//        Schedule schedule4 = new Schedule("tuesday", date2);
//        Schedule schedule5 = new Schedule("wednsday", date1);
//        Schedule schedule6 = new Schedule("wednsday", date2);
//        Schedule schedule7 = new Schedule("friday", date1);
//        Schedule schedule8 = new Schedule("friday", date2);
//        Schedule schedule9 = new Schedule("saturday", date1);
//        Schedule schedule10 = new Schedule("saturday", date2);
//        Schedule schedule11 = new Schedule("sunday", date1);
//        Schedule schedule12 = new Schedule("sunday", date2);
//        List listOfSchedules = new ArrayList();
//        List listOfRoutes = new ArrayList();
//        
//        listOfSchedules.add(schedule1);
//        listOfSchedules.add(schedule2);
//        listOfSchedules.add(schedule3);
//        listOfSchedules.add(schedule4);
//        listOfSchedules.add(schedule5);
//        listOfSchedules.add(schedule6);
//        listOfSchedules.add(schedule7);
//        listOfSchedules.add(schedule8);
//        listOfSchedules.add(schedule9);
//        listOfSchedules.add(schedule10);
//        listOfSchedules.add(schedule11);
//        listOfSchedules.add(schedule12);
//
//        Location firstLoc = new Location("Cph");
//        Location secondLoc = new Location("Malmø");
//        
//        Route r1 = new Route(firstLoc, secondLoc, "100", "60", listOfSchedules);
//        
//        listOfRoutes.add(r1);
//        
//
//
//
//        FerryType ferryType = new FerryType("Big Ferry", 10, 20, false, 0, 0);
//
//        Ferry ferry = new Ferry(ferryType, "The beautiful one");
//
//        Journey firstJourney = new Journey(ferry, new Date(12323), r1);
//        
//
//        Vehicle car = new Vehicle("Car", 2);
//
//        Reservation res = new Reservation("Raul","S",1,car,firstJourney);
//        
//        mylist.add(schedule1);
//        mylist.add(schedule2);
//        mylist.add(schedule3);
//        mylist.add(schedule4);
//        mylist.add(schedule5);
//        mylist.add(schedule6);
//        mylist.add(schedule7);
//        mylist.add(schedule8);
//        mylist.add(schedule9);
//        mylist.add(schedule10);
//        mylist.add(schedule11);
//        mylist.add(schedule12);
//
//        mylist.add(r1);
//        mylist.add(firstJourney);
//
//        mylist.add(firstLoc);
//        mylist.add(secondLoc);
//        mylist.add(ferryType);
//        mylist.add(ferry);
//
//        mylist.add(car);
//        mylist.add(res);
// 
//

//        em.persist(mylist);
        List as = new ArrayList();
        List locations = new ArrayList();
        JourneysDTO journey;
        
        ContractController c = new ContractController();
         locations = c.getLocations();
         as = c.getRoutes(1);
         journey = c.getJourney(1);
         
         System.out.println(c.makeReservation(1, 1, "Car"));
         
         System.out.println("Locations: "+ locations.toString());
         System.out.println("routes " + as.toString());
         System.out.println("Journeys: "+ journey.toString());
             

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
