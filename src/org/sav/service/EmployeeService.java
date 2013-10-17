package org.sav.service;

import org.sav.domain.Employee;

import javax.servlet.http.HttpServletRequest;

public class EmployeeService implements AjaxService{

    @Override
    public Object invokeAction(String action, HttpServletRequest request) {
        if(action.equals("getAll")){
            return getAll();
        }
        return null;
    }

    public Object[] getAll() {
        Object[] ret = new Object[2];
        Employee employee1 = new Employee();
        employee1.setName("John");
        employee1.setName("Smith");
        ret[0] = employee1;

        Employee employee2 = new Employee();
        employee2.setName("Peter");
        employee2.setLastName("Feel");
        ret[1] = employee2;
        return ret;
    }
}
