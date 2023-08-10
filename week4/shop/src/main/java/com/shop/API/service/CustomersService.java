package com.shop.API.service;

import com.shop.API.model.Customers;

import java.util.List;

public interface CustomersService {
    List<Customers> getCustomers();
    Customers saveCustomer (Customers customer);
    Customers getSingleCustomer (int id);
    void deleteCustomer (int id);
    Customers updateCustomer (Customers customer);
}
