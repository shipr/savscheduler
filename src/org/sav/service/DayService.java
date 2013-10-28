package org.sav.service;

import org.sav.dao.DayDao;
import org.sav.domain.Day;
import org.sav.service.container.JTableContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.Map;

@Path("/Day")
@Component
@Transactional(propagation = Propagation.REQUIRED)

public class DayService {

    private static final Logger LOG = LoggerFactory.getLogger(DayService.class);

    @Autowired
    private DayDao dayDao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public Map<String, Object> getAll(@FormParam("employeeId")long employeeId) {
        return JTableContainer.createRecords(dayDao.getAll(employeeId));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/create")
    public Map<String, Object> create(@QueryParam("employeeId")long employeeId, @FormParam("visitsDay") String visitsDay,
                                      @FormParam("fromTime") int fromTime, @FormParam("tillTime") int tillTime) throws ParseException {
        try {
            Day day = dayDao.createDay(employeeId, visitsDay, fromTime, tillTime);
            return JTableContainer.createRecord(day);
        } catch (Exception e) {
            LOG.warn(e.getMessage(), e);
            return JTableContainer.createFailed(e.getMessage());
        }

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/update")
    public Map<String, Object> update(@FormParam("employeeId")long employeeId, @FormParam("visitsDay") String visitsDay,
                                      @FormParam("fromTime") int fromTime, @FormParam("tillTime") int tillTime){
        try {
            Day day = dayDao.updateDay(employeeId, visitsDay, fromTime, tillTime);
            return JTableContainer.createRecord(day);
        } catch (Exception e) {
            LOG.warn(e.getMessage(), e);
            return JTableContainer.createFailed(e.getMessage());
        }

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/delete")
    public Map<String, Object> delete(@FormParam("dayId")long employeeId){
        return JTableContainer.createFailed();

    }





}
