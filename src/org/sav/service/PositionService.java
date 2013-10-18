package org.sav.service;

import org.sav.dao.PositionDao;
import org.sav.domain.Employee;
import org.sav.service.container.JTableContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Position")
@Component
@Transactional(propagation = Propagation.REQUIRED)
public class PositionService{

    @Autowired
    private PositionDao positionDao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public JTableContainer getAll() {
        JTableContainer containerColleaction = new JTableContainer("OK", positionDao.getAll());
        return containerColleaction;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/create")
    public JTableContainer create(@FormParam("name")String name){
        return new JTableContainer("OK", positionDao.create(name));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/update")
    public JTableContainer update(@FormParam("positionId")long positionId, @FormParam("name")String name){
        positionDao.update(positionId, name);
        return new JTableContainer("OK", null);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/delete")
    public JTableContainer delete(@FormParam("positionId")long positionId){
        positionDao.delete(positionId);
        JTableContainer containerColleaction = new JTableContainer("OK", null);
        return containerColleaction;
    }



}
