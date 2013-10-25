package org.sav.domain;


import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class DayPK implements Serializable {

    protected long employeeId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DayPK dayPK = (DayPK) o;

        if (employeeId != dayPK.employeeId) return false;
        if (visitsDay != null ? !visitsDay.equals(dayPK.visitsDay) : dayPK.visitsDay != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (employeeId ^ (employeeId >>> 32));
        result = 31 * result + (visitsDay != null ? visitsDay.hashCode() : 0);
        return result;
    }
}
