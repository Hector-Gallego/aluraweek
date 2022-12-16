package com.alurageek.alurageek.services.products;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alurageek.alurageek.models.Product;
import com.alurageek.alurageek.repositories.ICrudRepositoryProduct;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ICrudRepositoryProduct productRepository;

    
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
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product update(Product product, Long id) {

        Product productPersist = findById(id);
        productPersist.setName(product.getName());
        productPersist.setDescription(product.getDescription());
        productPersist.setUrl(product.getUrl());
        productPersist.setPrice(product.getPrice());

        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);   
    }  
}
