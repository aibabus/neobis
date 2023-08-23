package com.shop.ShopApplication.controller;

import com.shop.ShopApplication.service.ProductService;
import com.shop.ShopApplication.user.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

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
