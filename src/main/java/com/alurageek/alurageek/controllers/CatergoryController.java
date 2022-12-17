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

import com.alurageek.alurageek.models.Category;
import com.alurageek.alurageek.services.categories.ICategoryService;

@RestController
@RequestMapping("/api")
public class CatergoryController {


    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return categoryService.findAll();
    }


    @GetMapping("/categories/{id}")
    public Category getOneCategory(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @PostMapping("/categories")
    public Category saveCategory(@RequestBody Category category){
        return categoryService.save(category);
    }

    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category){
        return categoryService.update(category, id);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteById(id);
    }

}
