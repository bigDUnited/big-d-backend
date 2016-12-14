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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Route")
public class Route implements Serializable {

    public Route() {
    }

    public Route(Location departureLocation, Location destinationLocation, String distance, String duration, List<Schedule> schedule) {
        this.departureLocation = departureLocation;
        this.destinationLocation = destinationLocation;
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
    @Column(name = "distance")
    private String distance;

    @NotNull
    @Size(min = 2, max = 20)
    @Column(name = "duration")
    private String duration;

    @JoinColumn(name = "departureLocationId", referencedColumnName = "locationId")
    @ManyToOne()
    private Location departureLocation;

    @JoinColumn(name = "destinationLocationId", referencedColumnName = "locationId")
    @ManyToOne()
    private Location destinationLocation;

    @OneToMany()
    @JoinTable(
            name = "Route_Schedule",
            joinColumns = {
                @JoinColumn(name = "routeId", referencedColumnName = "routeId")},
            inverseJoinColumns = {
                @JoinColumn(name = "scheduleId", referencedColumnName = "scheduleId")}
    )
    private List<Schedule> schedule;

    public Integer getRouteId() {
        return routeId;
    }

    public void setrouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Location getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(Location departureLocation) {
        this.departureLocation = departureLocation;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(Location destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
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
        return "Route id" + routeId + " Departure location : "+departureLocation.getLocationName();
    }

}
