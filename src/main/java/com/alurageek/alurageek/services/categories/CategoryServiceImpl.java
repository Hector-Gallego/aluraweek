package com.alurageek.alurageek.services.categories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alurageek.alurageek.models.Category;
import com.alurageek.alurageek.repositories.CategoryRepository;
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    @Transactional(readOnly=true)
    public List<Category> findAll() {
        return (List<Category>)categoryRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category update(Category category, Long id) {
        
        // buscamos el objeto gaurdado con ese id
        Category categoryPersist = categoryRepository.findById(id).get();
        categoryPersist.setName(category.getName());

        return categoryRepository.save(categoryPersist);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
    
}
