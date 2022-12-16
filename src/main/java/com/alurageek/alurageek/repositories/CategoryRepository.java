package com.alurageek.alurageek.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alurageek.alurageek.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {  
}
