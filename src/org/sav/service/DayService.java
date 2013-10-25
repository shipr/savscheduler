package org.sav.service;

import org.sav.dao.DayDao;
import org.sav.dao.EmployeeDao;
import org.sav.domain.Day;
import org.sav.domain.Employee;
import org.sav.service.container.JTableContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Path("/Day")
@Component
@Transactional(propagation = Propagation.REQUIRED)

public class DayService {
    @Autowired
    private DayDao dayDao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public Map getAll() {
        return JTableContainer.createRecords(dayDao.getAll());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/create")
    public Map<String, Object> create(@FormParam("employeeId")long employeeId, @FormParam("visitDay") Date visitDay){
        Day day = dayDao.createDay(employeeId, visitDay);
        return JTableContainer.createRecord(day);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/update")
    public Map<String, Object> update(){
        return JTableContainer.createFailed();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/delete")
    public Map<String, Object> delete(@FormParam("dayId")long employeeId){
        return JTableContainer.createFailed();

    }





}
