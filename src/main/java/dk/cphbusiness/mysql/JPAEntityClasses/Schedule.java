/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.mysql.JPAEntityClasses;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author redrose
 */
@Entity
@Table(name = "Schedule")
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer scheduleId;
    
    @NotNull
    @Size(min = 2, max = 20)
    @Column(name="dayOfWeek")
    private String dayOfWeek;
    
    @NotNull
    @Size(min = 2, max = 20)
    @Column(name="startHour")
    private Date startHour;
    
    public Schedule() {
    }

    public Schedule(String dayOfWeek, Date startHour) {
        this.dayOfWeek = dayOfWeek;
        this.startHour = startHour;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scheduleId != null ? scheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.scheduleId == null && other.scheduleId != null) || (this.scheduleId != null && !this.scheduleId.equals(other.scheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dk.cphbusiness.mysql.JPAEntityClasses.Schedule[ id=" + scheduleId + " ]";
    }
    
}
