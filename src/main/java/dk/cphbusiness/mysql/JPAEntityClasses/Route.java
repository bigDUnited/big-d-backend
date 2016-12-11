/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.mysql.JPAEntityClasses;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity("name Route")
@Table(name = "Route")
public class Route implements Serializable {
    
    public Route(){
        
    }

    public Route(String distance, String duration, List<Schedule> schedule) {
        this.distance = distance;
        this.duration = duration;
        this.schedule = schedule;
    }
    
          
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;
    
    @NotNull
    @Size(min = 2, max = 20)
    @Column(name="distance")
    private String  distance;
    
    @NotNull
    @Size(min = 2, max = 20)
    @Column(name="duration")
    private String  duration;
    
    @OneToMany()
    @JoinTable(
            name = "Route_Schedule",
            joinColumns = {@JoinColumn(name = "routeId",referencedColumnName = "routeId")},
            inverseJoinColumns = {@JoinColumn(name = "scheduleId",referencedColumnName = "scheduleId")}
    )
    private List<Schedule> schedule;


    public Integer getRouteId() {
        return routeId;
    }

    public void setrouteId(Integer routeId) {
        this.routeId = routeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routeId != null ? routeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.routeId == null && other.routeId != null) || (this.routeId != null && !this.routeId.equals(other.routeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dk.cphbusiness.mysql.JPAEntityClasses.Route[ id=" + routeId + " ]";
    }
    
}
