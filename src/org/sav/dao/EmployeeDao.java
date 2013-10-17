package org.sav.dao;

import org.sav.domain.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeDao{

    private static EmployeeDao instance = new EmployeeDao();
    private long employeeId = 1;

    private List<Employee> employees = new ArrayList<Employee>();

    public EmployeeDao() {
        createEmployee("John", "Smith");
        createEmployee("Peter", "Feel");

    }

    public static EmployeeDao getInstance() {
        return instance;
    }

    public List<Employee> getAll(){
        return employees;
    }


    public Employee createEmployee(String name, String lastName) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeId++);
        employee.setName(name);
        employee.setLastName(lastName);
        employees.add(employee);
        return employee;
    }

    public void updateEmployee(long employeeId, String name, String lastName) {
        for (Employee employee : employees) {
            if(employee.getEmployeeId() == employeeId){
                employee.setName(name);
                employee.setLastName(lastName);
            }
        }
    }

    public void deleteEmployee(long employeeId) {
        for(Iterator<Employee> it = employees.iterator();it.hasNext(); ){
            Employee employee = it.next();
            if(employee.getEmployeeId() == employeeId){
                it.remove();
            }
        }
    }
}
