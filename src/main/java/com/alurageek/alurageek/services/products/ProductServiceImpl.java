package com.alurageek.alurageek.services.products;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alurageek.alurageek.models.Category;
import com.alurageek.alurageek.models.Product;
import com.alurageek.alurageek.repositories.ProductRepository;
import com.alurageek.alurageek.services.categories.CategoryServiceImpl;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryServiceImpl categoryService;

    
    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Product save(Product product) {

        Category category = product.getCategory();
        // busco en la base de datos si la categoria existe y la enlazo al objeto
        Category categoryPersist = categoryService.findById(category.getId());

        product.setCategory(categoryPersist);

        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product updateProduct(Product product, Long id) {

       
    
        Product productPersist = findById(id);

        productPersist.setName(product.getName());
        productPersist.setDescription(product.getDescription());
        productPersist.setUrl(product.getUrl());
        productPersist.setPrice(product.getPrice());
        productPersist.setCategory(product.getCategory());

        System.out.println("======================================="+productPersist);

        return save(productPersist);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);   
    }  
}
