package org.sav.domain;

import org.hibernate.annotations.GenericGenerator;
import org.sav.util.JsonDateAdapter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@Entity
@Table(name = "day")
@IdClass(DayPK.class)
public class Day {

    @Id
    @Column(name = "employee_id", insertable = true, updatable = false)
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long employeeId;

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "visits_day", insertable = true, updatable = false)
    @XmlJavaTypeAdapter(JsonDateAdapter.class)
    private Date visitsDay;

    @Column(name = "from_time", nullable =false)
    private int fromTime;

    @Column(name = "till_time", nullable =false)
    private int tillTime;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getVisitsDay() {
        return visitsDay;
    }

    public void setVisitsDay(Date visitsDay) {
        this.visitsDay = visitsDay;
    }

    public int getFromTime() {
        return fromTime;
    }

    public void setFromTime(int fromTime) {
        this.fromTime = fromTime;
    }

    public int getTillTime() {
        return tillTime;
    }

    public void setTillTime(int tillTime) {
        this.tillTime = tillTime;
    }
}
