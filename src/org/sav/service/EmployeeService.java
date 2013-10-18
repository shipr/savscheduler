package org.sav.service;

import org.sav.dao.EmployeeDao;
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

@Path("/Employee")
@Component
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public JTableContainer getAll() {
        JTableContainer containerColleaction = new JTableContainer("OK", employeeDao.getAll());
        return containerColleaction;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/createEmployee")
    public JTableContainer createEmployee(@FormParam("name")String name, @FormParam("lastName") String lastName){
        Employee employee = employeeDao.createEmployee(name, lastName);
        return new JTableContainer("OK", employee);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/updateEmployee")
    public JTableContainer updateEmployee(@FormParam("employeeId")long employeeId, @FormParam("name")String name,
                                                @FormParam("lastName") String lastName){
        employeeDao.updateEmployee(employeeId, name, lastName);
        return new JTableContainer("OK", null);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/deleteEmployee")
    public JTableContainer deleteEmployee(@FormParam("employeeId")long employeeId){
        employeeDao.deleteEmployee(employeeId);
        JTableContainer containerColleaction = new JTableContainer("OK", null);
        return containerColleaction;
    }

}
