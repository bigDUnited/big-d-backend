
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.mysql.JPAEntityClasses;

import dtos.LocationDTO;
import java.sql.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
                System.out.println("1");

        EntityMigrator em = new EntityMigrator();
        DateFormat time = new SimpleDateFormat("HH:mm:ss");
        Date date1 = time.parse("20:00:00");
        ArrayList<Object> mylist = new ArrayList<Object>(); 
        Schedule schedule1 = new Schedule("monday",date1);
        Schedule schedule2 = new Schedule("tuesday",date1);
        List listOfSchedules = new ArrayList();
        List listOfRoutes = new ArrayList();
        
                System.out.println("2" + listOfRoutes.size());


        
        listOfSchedules.add(schedule1);
        listOfSchedules.add(schedule2);
        
        Route r1 = new Route("a lot", "More", listOfSchedules);  
        System.out.println("ROUTE   #@#@#@  oject" + r1.getRouteId());
        listOfRoutes.add(r1);
        
        mylist.add(r1);
        
        System.out.println("list of routes befoore object creation" + listOfRoutes.size());
        Location firstLoc = new Location("Cph", listOfRoutes);
        Location secondLoc = new Location("Malmø", listOfRoutes);
        System.out.println("LOCATION   #@#@#@  oject" + firstLoc.getId());


        mylist.add(firstLoc);
        mylist.add(secondLoc);

        FerryType ferryType = new FerryType("Big Ferry", 10, 20, false, 0, 0);
        mylist.add(ferryType);
        Ferry ferry = new Ferry(ferryType, "The beautiful one");
        mylist.add(ferry);

        Journey firstJourney = new Journey(firstLoc,secondLoc,ferry, new Date(12323), r1);
        mylist.add(firstJourney);
        Vehicle car = new Vehicle("Car", 2);
        mylist.add(car);
        
        Reservation res = new Reservation("Raul","S",1,car,firstJourney);
        mylist.add(res);
        
;
        mylist.add(schedule1);
        mylist.add(schedule2);



       em.persist(mylist);
//       ContractController c = new ContractController();
////     c.getRoutes(1);
//       c.getRoutes(1);

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
