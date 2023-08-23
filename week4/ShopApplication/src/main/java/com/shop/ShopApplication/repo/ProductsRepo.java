package com.shop.ShopApplication.repo;

import com.shop.ShopApplication.user.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepo extends JpaRepository<Products, Integer> {

}
