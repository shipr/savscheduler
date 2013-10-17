package org.sav.service;

import javax.servlet.http.HttpServletRequest;

public class EmployeeService implements AjaxService{

    @Override
    public AjaxResult invokeAction(String action, HttpServletRequest request) {
        if(action.equals("getAll")){
            return getAll();
        }
        return null;
    }

    public AjaxResult getAll() {
        return new AjaxResult();
    }
}
