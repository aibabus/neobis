package com.onlineStore.onlineStore.Controller;

import com.onlineStore.onlineStore.Entity.Products;
import com.onlineStore.onlineStore.Entity.User;
import com.onlineStore.onlineStore.Repository.ProductsRepository;
import com.onlineStore.onlineStore.Repository.UserRepository;
import com.onlineStore.onlineStore.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping("/saveProduct")
    public Products saveProducts(@RequestBody Products products){
        return productService.saveProduct(products);
    }

    @GetMapping("/findProducts")
    public List<Products> findAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("/findProduct/{id}")
    public Products findProduct(@PathVariable int id){
        return productService.getSingleProduct(id);
    }

    @PutMapping("/updateProduct/{id}")
    public Products updateProduct(@PathVariable int id, @RequestBody Products products){
        products.setProduct_id(id);
        return productService.updateProduct(products);

    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@RequestParam int id){
        productService.deleteProduct(id);

    }

}
