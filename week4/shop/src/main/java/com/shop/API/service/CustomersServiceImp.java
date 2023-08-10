package com.shop.API.service;

import com.shop.API.model.Customers;
import com.shop.API.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersServiceImp implements CustomersService{

    @Autowired
    private CustomerRepository cRepository;
    @Override
    public List<Customers> getCustomers() {
        return cRepository.findAll();
    }

    @Override
    public Customers saveCustomer(Customers customer) {
        return cRepository.save(customer);
    }

    @Override
    public Customers getSingleCustomer(int id) {
        Optional<Customers> customer = cRepository.findById(id);
        if (customer.isPresent()){
            return customer.get();
        }
        throw new RuntimeException("Customer is not find " + id);
    }

    @Override
    public void deleteCustomer(int id) {
        cRepository.deleteById(id);
    }

    @Override
    public Customers updateCustomer(Customers customer) {
        return cRepository.save(customer);
    }
}
