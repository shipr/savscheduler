package org.sav.service;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory{

    private static ServiceFactory instance = new ServiceFactory();
    private Map<String, AjaxService> serviceMap = new HashMap<String, AjaxService>();

    public ServiceFactory() {
        serviceMap.put("EmployeeService", new EmployeeService());
    }

    public static ServiceFactory getInstance() {
            return instance;
        }


    public AjaxService getService(String service) {
        return serviceMap.get(service);
    }
}
