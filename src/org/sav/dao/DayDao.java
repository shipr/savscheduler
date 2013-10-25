package org.sav.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.sav.domain.Day;
import org.sav.domain.DayPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DayDao {


    @Autowired
    private SessionFactory sessionFactory;

    public List<Day> getAll(){
        return sessionFactory.getCurrentSession().createCriteria(Day.class).list();
    }


    public Day createDay(long employeeId, Date visitDay) {
        if(employeeId == 0 || visitDay == null){
            return null;
        }
        Day day = new Day();
        day.setEmployeeId(employeeId);
        day.setVisitsDay(visitDay);
        sessionFactory.getCurrentSession().persist(day);
        return day;

    }
}
