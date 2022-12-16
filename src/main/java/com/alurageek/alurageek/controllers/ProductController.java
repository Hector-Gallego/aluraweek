package com.alurageek.alurageek.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alurageek.alurageek.models.Product;
import com.alurageek.alurageek.services.products.IProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    IProductService productService;


    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.findAll();
    }


    @GetMapping("/products/{id}")
    public Product getOneProduct(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        System.out.println(product);
        return productService.updateProduct(product, id);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteById(id);
    }

}
