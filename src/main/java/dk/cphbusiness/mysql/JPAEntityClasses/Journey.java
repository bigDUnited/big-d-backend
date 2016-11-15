/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.mysql.JPAEntityClasses;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author raul
 */
@Entity
@Table(name = "Journeys")
public class Journey implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
//    
//    @JoinColumn(name = "departureLocationId", referencedColumnName = "locationId")
//    @OneToOne()
//    private Location departureLocation;
    
    @JoinColumn(name = "destinationLocationId", referencedColumnName = "locationId")
    @ManyToOne()
    private Location destinationLocation;

    public Journey(Location departureLocation, Location destinationLocation) {
//        this.departureLocation = departureLocation;
        this.destinationLocation = destinationLocation;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Journey)) {
            return false;
        }
        Journey other = (Journey) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dk.cphbusiness.mysql.JPAEntityClasses.Journey[ id=" + id + " ]";
    }
    
}
