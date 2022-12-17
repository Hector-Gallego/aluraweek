package com.alurageek.alurageek.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.alurageek.alurageek.models.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {   
    List<Product> findByCategoryId(Long id);
}
