package org.sav.service;

import org.sav.dao.EmployeeDao;
import org.sav.domain.Employee;
import org.sav.service.container.JTableContainer;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Employee")
public class EmployeeService implements AjaxService{

    @Override
    public Object invokeAction(String action, HttpServletRequest request) {
        if(action.equals("getAll")){
            return getAll();
        }
        return null;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public JTableContainer getAll() {
        JTableContainer containerColleaction = new JTableContainer("OK", EmployeeDao.getInstance().getAll());
        return containerColleaction;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/createEmployee")
    public JTableContainer createEmployee(@FormParam("name")String name, @FormParam("lastName") String lastName){
        Employee employee = EmployeeDao.getInstance().createEmployee(name, lastName);
        JTableContainer containerColleaction = new JTableContainer("OK", employee);
        return containerColleaction;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/updateEmployee")
    public JTableContainer updateEmployee(@FormParam("employeeId")long employeeId, @FormParam("name")String name,
                                                @FormParam("lastName") String lastName){
        EmployeeDao.getInstance().updateEmployee(employeeId, name, lastName);
        JTableContainer containerColleaction = new JTableContainer("OK", null);
        return containerColleaction;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/deleteEmployee")
    public JTableContainer deleteEmployee(@FormParam("employeeId")long employeeId){
        EmployeeDao.getInstance().deleteEmployee(employeeId);
        JTableContainer containerColleaction = new JTableContainer("OK", null);
        return containerColleaction;
    }

}
