package com.alurageek.alurageek.repositories;

import org.springframework.data.repository.CrudRepository;
import com.alurageek.alurageek.models.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {   
}
