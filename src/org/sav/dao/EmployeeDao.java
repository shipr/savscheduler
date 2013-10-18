package org.sav.dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.sav.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeDao{

    @Autowired
    private SessionFactory sessionFactory;

    public List<Employee> getAll(){
        return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
    }


    public Employee createEmployee(String name, String lastName) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setLastName(lastName);
        sessionFactory.getCurrentSession().persist(employee);
        return employee;
    }

    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
    }

    public Employee getEmployee(long employeeId) {
        return getEmployee(employeeId, sessionFactory.getCurrentSession());
    }

    private Employee getEmployee(long employeeId, Session session) {
        return (Employee)session.get(Employee.class, employeeId);
    }

    public void deleteEmployee(long employeeId) {
            Session session = sessionFactory.getCurrentSession();
        Employee employee = getEmployee(employeeId, session);
        session.delete(employee);
        }
}
