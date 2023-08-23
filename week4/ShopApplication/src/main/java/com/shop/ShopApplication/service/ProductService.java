package com.shop.ShopApplication.service;

import com.shop.ShopApplication.user.Products;

import java.util.List;

public interface ProductService {
    List<Products> getProducts();
    Products saveProduct (Products products);
    Products getSingleProduct (int id);
    void deleteProduct (int id);
    Products updateProduct (Products products);
}
