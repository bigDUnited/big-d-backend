/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.mysql.JPAEntityClasses;

import dtos.JourneysDTO;
import dtos.LocationDTO;
import dtos.ReservationSummaryDTO;
import dtos.RouteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author redrose
 */
public class ContractController implements contractinterface.ContractInterface  {

    @Override
    public List<LocationDTO> getLocations() {
        List<LocationDTO> list = new ArrayList();
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("bigDPersistence");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
        Query query = em.createQuery("SELECT l FROM Locations l");
        list = query.getResultList();
        System.out.println("number of locations in the db " + list.size());
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            System.exit(0);
        } finally {
            em.getTransaction().commit();
            em.close();
        }
      return list;
    }

    @Override
    public List<RouteDTO> getRoutes(int i) {
        List<RouteDTO> list = new ArrayList();
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("bigDPersistence");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
        Query query = em.createNativeQuery("select Route.routeId,\n" +
        "(select Locations.locationName from Route inner join Locations on Locations.locationId = Route.departureLocationId where Route.destinationLocationId = "+i+"),\n" +
        "(select Locations.locationName from Route inner join Locations on Locations.locationId = Route.departureLocationId where Route.destinationLocationId !="+i+")\n" +
        "from Route LIMIT 1");
        list = query.getResultList();
        System.out.println("Route " + list.toString());
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            System.exit(0);
        } finally {
            em.getTransaction().commit();
            em.close();
        }
      return list;
    }

    @Override
    public JourneysDTO getJourney(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReservationSummaryDTO makeReservation(int i, int i1, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
