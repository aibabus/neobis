package com.shop.API.controller;

import com.shop.API.model.Customers;
import com.shop.API.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomersController {
    @Autowired
    private CustomersService cService;

    @GetMapping("/customers")
    public List<Customers> getCustomer(){
        return cService.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customers getCustomer(@PathVariable int id){
        return cService.getSingleCustomer(id);
    }

    @PostMapping("/customer")
    public Customers saveCustomer(@RequestBody Customers customer){
        return cService.saveCustomer(customer);
    }

    @PutMapping("/customers/{id}")
    public Customers updateCustomer(@PathVariable int id, @RequestBody Customers customer){
        customer.setCustomers_id(id);
        return cService.updateCustomer(customer);

    }

    //localhost:8080/employees?id=34
    @DeleteMapping("/customers")
    public void deleteCustomer(@RequestParam int id){
        cService.deleteCustomer(id);

    }
}
