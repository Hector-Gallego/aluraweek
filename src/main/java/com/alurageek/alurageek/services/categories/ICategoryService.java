package com.alurageek.alurageek.services.categories;

import java.util.List;

import com.alurageek.alurageek.models.Category;

public interface ICategoryService {
    
    List<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    Category update(Category category, Long id);
    void deleteById(Long id);
}
