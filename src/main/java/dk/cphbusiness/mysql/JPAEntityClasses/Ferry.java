/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.mysql.JPAEntityClasses;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author raul
 */
@Entity
@Table(name="Ferries")
@PrimaryKeyJoinColumn(name = "ferryTypeId")
public class Ferry extends FerryType  {
//
    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @NotNull
//    private Integer ferryId;

    @NotNull
    @Size(min = 1, max = 20)
    private String ferryName;

    public Ferry() {
    }

    public Ferry(String name, int humanCapacity, int vehicleCapacity, boolean isDeckRemovable, int vehicleCapacityWhenDeckRemoved, int humanCapacityWhenDeckRemoved) {
        super(name, humanCapacity, vehicleCapacity, isDeckRemovable, vehicleCapacityWhenDeckRemoved, humanCapacityWhenDeckRemoved);
    }

    public Ferry(FerryType ferryType,String name) {
        super(ferryType.getName(),ferryType.getHumanCapacity(),ferryType.getVehicleCapacity(),ferryType.isIsDeckRemovable(),ferryType.getVehicleCapacityWhenDeckRemoved(),ferryType.getHumanCapacityWhenDeckRemoved());
        this.ferryName = name;
    }

    @Override
    public String toString() {
        return "dk.cphbusiness.mysql.JPAEntityClasses.Ferry[ id=" + getId() + " ]";
    }
    
}
