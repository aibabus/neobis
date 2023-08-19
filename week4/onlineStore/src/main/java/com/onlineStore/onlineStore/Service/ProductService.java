package com.onlineStore.onlineStore.Service;

import com.onlineStore.onlineStore.Entity.Products;
import com.onlineStore.onlineStore.Entity.User;

import java.util.List;

public interface ProductService {
    List<Products> getProducts();
    Products saveProduct (Products products);
    Products getSingleProduct (int id);
    void deleteProduct (int id);
    Products updateProduct (Products products);
}
