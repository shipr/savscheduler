package org.sav.service;

import org.sav.dao.PositionDao;
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
import java.util.Map;

@Path("/Position")
@Component
@Transactional(propagation = Propagation.REQUIRED)
public class PositionService{

    @Autowired
    private PositionDao positionDao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public Map<String, Object> getAll() {
        return JTableContainer.createRecords(positionDao.getAll());
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllOptions")
    public Map<String, Object> getAllOptions() {
        return JTableContainer.createOptions(positionDao.getAll());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/create")
    public Map<String, Object> create(@FormParam("positionName")String name){
        return JTableContainer.createRecord(positionDao.create(name));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/update")
    public Map<String, Object> update(@FormParam("positionId")long positionId, @FormParam("positionName")String name){
        positionDao.update(positionId, name);
        return JTableContainer.createOK();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/delete")
    public Map<String, Object> delete(@FormParam("positionId")long positionId){
        positionDao.delete(positionId);
        return JTableContainer.createOK();
    }



}
