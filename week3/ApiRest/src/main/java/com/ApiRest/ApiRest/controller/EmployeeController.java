package com.ApiRest.ApiRest.controller;
import com.ApiRest.ApiRest.model.Employee;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class EmployeeController {

    //localhost:8080/employees
    @GetMapping("/employees")
    public String getEmployees(){
        return "displaying the list of employees";
    }

    //localhost:8080/employees/12
    @GetMapping("/employees/{id}")
    public String getEmployee(@PathParam("id") Long id){
        return "Fetching the employee details for the id " + id;
    }

    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee){
        return "Saving the employee details to the database" + employee;
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        System.out.println("Updating the employee data for the id " + id);
        return employee;

    }

    //localhost:8080/employees?id=34
    @DeleteMapping("/employees")
    public String deleteEmployee(@RequestParam Long id){
        return "Deleting the employee details for the id " + id;

    }

}
