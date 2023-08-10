package com.ApiRest.ApiRest.Service;

import com.ApiRest.ApiRest.model.Employee;

import java.util.List;

public interface EmployeesService {
    List<Employee> getEmployee();

    List<Employee> getEmployees();

    Employee saveEmployee (Employee employee);
    Employee getSingleEmployee (Long id);
    void deleteEmployee (Long id);
    Employee updateEmployee (Employee employee);
}
