package com.onlineStore.onlineStore.Repository;

import com.onlineStore.onlineStore.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
