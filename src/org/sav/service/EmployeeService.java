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
        return new JTableContainer("OK", employeeDao.getAll());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/create")
    public JTableContainer create(@FormParam("name")String name, @FormParam("lastName") String lastName){
        Employee employee = employeeDao.createEmployee(name, lastName);
        return new JTableContainer(employee);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/update")
    public JTableContainer update(@FormParam("employeeId")long employeeId, @FormParam("name")String name,
                                                @FormParam("lastName") String lastName,
                                                @FormParam("positions") String positions){
        Employee employee = employeeDao.getEmployee(employeeId);
        employee.setName(name);
        employee.setLastName(lastName);
        employee.getPositions().clear();
        if(positions != null && !positions.isEmpty()){
            for (String s : positions.split("\\,")) {
                long pos = Long.parseLong(s);
                if(pos != 0){
                    employee.getPositions().add(pos);
                }
            }
        }
        employeeDao.updateEmployee(employee);
        return new JTableContainer();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/delete")
    public JTableContainer delete(@FormParam("employeeId")long employeeId){
        employeeDao.deleteEmployee(employeeId);
        return new JTableContainer();
    }

}
