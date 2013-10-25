package org.sav.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "day")
@IdClass(DayPK.class)
public class Day {

    @Id
    @Column(name = "employee_id", insertable = true, updatable = false)
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    protected long employeeId;

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "visits_day", insertable = true, updatable = false)
    protected Date visitsDay;

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
}
