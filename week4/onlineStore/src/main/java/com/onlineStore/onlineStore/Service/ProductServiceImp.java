package com.onlineStore.onlineStore.Service;

import com.onlineStore.onlineStore.Entity.Products;
import com.onlineStore.onlineStore.Entity.User;
import com.onlineStore.onlineStore.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductsRepository productsRepository;
    @Override
    public List<Products> getProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Products saveProduct(Products products) {
        return productsRepository.save(products);
    }

    @Override
    public Products getSingleProduct(int id) {
        Optional<Products> products = productsRepository.findById(id);
        if (products.isPresent()){
            return products.get();
        }
        throw new RuntimeException("Product is not find " + id);
    }

    @Override
    public void deleteProduct(int id) {
        productsRepository.deleteById(id);
    }

    @Override
    public Products updateProduct(Products products) {
        return productsRepository.save(products);
    }
}
