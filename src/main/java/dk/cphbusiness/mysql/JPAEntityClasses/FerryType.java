/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.mysql.JPAEntityClasses;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import static javax.persistence.InheritanceType.JOINED;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author raul
 */
@Entity
@Inheritance(strategy = JOINED)
@Table(name = "FerryTypes")
public class FerryType implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ferryTypeId;
    
    @NotNull
    @Size(min = 2, max = 20)
    private String name;
    
    @NotNull
    private int humanCapacity;
    
    @NotNull
    private int vehicleCapacity;
    
    @NotNull
    private boolean isDeckRemovable;
    
    private int vehicleCapacityWhenDeckRemoved;
    
    private int humanCapacityWhenDeckRemoved;
//
    public FerryType() {
    }
    
    public FerryType(String name, int humanCapacity, int vehicleCapacity, boolean isDeckRemovable, int vehicleCapacityWhenDeckRemoved, int humanCapacityWhenDeckRemoved) {
        this.name = name;
        this.humanCapacity = humanCapacity;
        this.vehicleCapacity = vehicleCapacity;
        this.isDeckRemovable = isDeckRemovable;
        this.vehicleCapacityWhenDeckRemoved = vehicleCapacityWhenDeckRemoved;
        this.humanCapacityWhenDeckRemoved = humanCapacityWhenDeckRemoved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHumanCapacity() {
        return humanCapacity;
    }

    public void setHumanCapacity(int humanCapacity) {
        this.humanCapacity = humanCapacity;
    }

    public int getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void setVehicleCapacity(int vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public boolean isIsDeckRemovable() {
        return isDeckRemovable;
    }

    public void setIsDeckRemovable(boolean isDeckRemovable) {
        this.isDeckRemovable = isDeckRemovable;
    }

    public int getVehicleCapacityWhenDeckRemoved() {
        return vehicleCapacityWhenDeckRemoved;
    }

    public void setVehicleCapacityWhenDeckRemoved(int vehicleCapacityWhenDeckRemoved) {
        this.vehicleCapacityWhenDeckRemoved = vehicleCapacityWhenDeckRemoved;
    }

    public int getHumanCapacityWhenDeckRemoved() {
        return humanCapacityWhenDeckRemoved;
    }

    public void setHumanCapacityWhenDeckRemoved(int humanCapacityWhenDeckRemoved) {
        this.humanCapacityWhenDeckRemoved = humanCapacityWhenDeckRemoved;
    }
    
    public Integer getId() {
        return ferryTypeId;
    }

    public void setId(Integer id) {
        this.ferryTypeId = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ferryTypeId != null ? ferryTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FerryType)) {
            return false;
        }
        FerryType other = (FerryType) object;
        if ((this.ferryTypeId == null && other.ferryTypeId != null) || (this.ferryTypeId != null && !this.ferryTypeId.equals(other.ferryTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dk.cphbusiness.mysql.JPAEntityClasses.FerryType[ id=" + ferryTypeId + " ]";
    }
    
}
