package com.alurageek.alurageek.repositories;

import org.springframework.data.repository.CrudRepository;
import com.alurageek.alurageek.models.Product;

public interface ICrudRepositoryProduct extends CrudRepository<Product,Long> {   
}
