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
import java.util.List;
import java.util.Map;

@Path("/Employee")
@Component
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public Map getAll(@FormParam("positionId")long positionId) {
        return JTableContainer.createRecords(employeeDao.getAll(positionId));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/create")
    public Map<String, Object> create(@FormParam("name")String name, @FormParam("lastName") String lastName){
        Employee employee = employeeDao.createEmployee(name, lastName);
        return JTableContainer.createRecord(employee);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/update")
    public Map<String, Object> update(@FormParam("employeeId")long employeeId, @FormParam("name")String name,
                                                @FormParam("lastName") String lastName,
                                                @FormParam("positions") List<Long> positions){
        Employee employee = employeeDao.getEmployee(employeeId);
        employee.setName(name);
        employee.setLastName(lastName);
        employee.getPositions().clear();
        if(positions != null && !positions.isEmpty()){
            for (Long position : positions) {
                if(position != 0){
                    employee.getPositions().add(position);
                }
            }
        }
        employeeDao.updateEmployee(employee);
        return JTableContainer.createOK();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/delete")
    public Map<String, Object> delete(@FormParam("employeeId")long employeeId){
        boolean ret = employeeDao.deleteEmployee(employeeId);
        if(ret){
            return JTableContainer.createOK();
        }else {
            return JTableContainer.createFailed();
        }
    }

}
