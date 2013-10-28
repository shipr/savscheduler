package org.sav.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.sav.domain.Day;
import org.sav.domain.DayPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class DayDao {

    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private SessionFactory sessionFactory;

    public List<Day> getAll(long employeeId){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Day.class);
        if(employeeId != 0){
            criteria.add(Restrictions.eq("employeeId", employeeId));
        }
        return criteria.list();
    }


    public Day createDay(long employeeId, String visitsDay, int fromTime, int tillTime) throws Exception{
        if(employeeId == 0 || visitsDay == null){
            throw new IllegalArgumentException("parameters cannot be null");
        }
        Day day = new Day();
        day.setEmployeeId(employeeId);
        day.setVisitsDay(df.parse(visitsDay));
        day.setFromTime(fromTime);
        day.setTillTime(tillTime);
        sessionFactory.getCurrentSession().persist(day);
        return day;

    }

    public Day updateDay(long employeeId, String visitsDay, int fromTime, int tillTime) throws Exception {
        if(employeeId == 0 || visitsDay == null){
            throw new IllegalArgumentException("parameters cannot be null");
        }
        DayPK dayPK = new DayPK();
        dayPK.setEmployeeId(employeeId);
        dayPK.setVisitsDay(df.parse(visitsDay));
        Day day = (Day) sessionFactory.getCurrentSession().get(Day.class, dayPK);
        if(day == null){
            throw new IllegalArgumentException("Cannot find object to update");
        }
        day.setEmployeeId(employeeId);
        day.setVisitsDay(df.parse(visitsDay));
        day.setFromTime(fromTime);
        day.setTillTime(tillTime);
        sessionFactory.getCurrentSession().update(day);
        return day;

    }
}
