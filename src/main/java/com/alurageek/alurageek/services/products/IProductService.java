package com.alurageek.alurageek.services.products;

import java.util.List;
import com.alurageek.alurageek.models.Product;

public interface IProductService {

    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    Product updateProduct(Product product, Long id);
    void deleteById(Long id);
   
}
