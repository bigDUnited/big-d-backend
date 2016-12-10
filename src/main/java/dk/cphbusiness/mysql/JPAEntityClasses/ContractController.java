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
import java.util.List;

/**
 *
 * @author redrose
 */
public class ContractController implements contractinterface.ContractInterface  {

    @Override
    public List<LocationDTO> getLocations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RouteDTO> getRoutes(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
