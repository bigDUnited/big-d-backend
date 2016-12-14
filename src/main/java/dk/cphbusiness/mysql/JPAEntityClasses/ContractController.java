/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.mysql.JPAEntityClasses;

import dtos.JourneySummaryDTO;
import dtos.JourneysDTO;
import dtos.LocationDTO;
import dtos.ReservationSummaryDTO;
import dtos.RouteDTO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author redrose
 */
public class ContractController implements contractinterface.ContractInterface {

    @Override
    public List<LocationDTO> getLocations() {
        List<LocationDTO> list = new ArrayList();
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("bigDPersistence");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            TypedQuery<Location> query = em.createQuery("SELECT l FROM Locations l", Location.class);
            for (Location location : query.getResultList()) {
                LocationDTO l = new LocationDTO(location.getId(), location.getLocationName());
                list.add(l);
            }
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
    public List<RouteDTO> getRoutes(int locationId) {
        List<RouteDTO> list = new ArrayList();
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("bigDPersistence");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            TypedQuery<Route> query = em.createQuery("SELECT r FROM Route r where r.destinationLocation = " + locationId, Route.class);
            for (Route test : query.getResultList()) {
                RouteDTO t = new RouteDTO(test.getRouteId(), test.getDepartureLocation().getLocationName(), test.getDestinationLocation().getLocationName());
                list.add(t);
            }
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
    public JourneysDTO getJourney(int routeId) {
        JourneysDTO journeyDTO = null;

        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("bigDPersistence");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            TypedQuery<Journey> query = em.createQuery("SELECT j FROM Journey j where j.route = " + routeId, Journey.class);
            List<JourneySummaryDTO> journeySummaryDTO = new ArrayList<JourneySummaryDTO>();

            for (Journey journey : query.getResultList()) {

                Calendar cal = Calendar.getInstance();
                cal.setTime(journey.getDate());
                cal.add(Calendar.MINUTE, Integer.parseInt(journey.getRoute().getDuration()));
                Date arrivalDate = cal.getTime();

                JourneySummaryDTO jsd = new JourneySummaryDTO(journey.getId(), journey.getDate(), arrivalDate, journey.getFerry().getName());
                journeySummaryDTO.add(jsd);

            }
            journeyDTO = new JourneysDTO(journeySummaryDTO, query.getResultList().get(0).getRoute().getDepartureLocation().getLocationName(), query.getResultList().get(0).getRoute().getDestinationLocation().getLocationName());
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            System.exit(0);
        } finally {
            em.getTransaction().commit();
            em.close();
        }
        return journeyDTO;
    }

    @Override
    public ReservationSummaryDTO makeReservation(int journeyId, int nrOfPeople, String vehicleType) {
        ReservationSummaryDTO reservationDTO = null;

        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("bigDPersistence");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            TypedQuery<Vehicle> findVehicle = em.createQuery("SELECT v FROM Vehicle v where v.name = '" + vehicleType + "'", Vehicle.class);
            Vehicle v = findVehicle.getSingleResult();

            TypedQuery<Journey> journey = em.createQuery("SELECT j FROM Journey j where j.id = " + journeyId, Journey.class);
            Journey j = journey.getSingleResult();

            Reservation reservation = new Reservation(nrOfPeople, v, j);
            em.persist(reservation);

            Calendar cal = Calendar.getInstance();
            cal.setTime(reservation.getJourney().getDate());
            cal.add(Calendar.MINUTE, Integer.parseInt(reservation.getJourney().getRoute().getDuration()));
            Date arrivalDate = cal.getTime();

            String departureLocation = reservation.getJourney().getRoute().getDepartureLocation().getLocationName();
            String destinationLocation = reservation.getJourney().getRoute().getDestinationLocation().getLocationName();
            String ferryName = reservation.getJourney().getFerry().getName();
            int numberOfPeople = reservation.getNumOfPeople();
            int referenceNumber = reservation.getId();
            String vehicleName = reservation.getVehicle().getName();
            Date departureDate = reservation.getJourney().getDate();

            reservationDTO = new ReservationSummaryDTO(departureLocation, destinationLocation, departureDate, arrivalDate, ferryName, numberOfPeople, vehicleName, referenceNumber);

            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return null;
        }
        return reservationDTO;
    }

}
