package com.java.pharmacy.service;

import com.java.pharmacy.model.Product;
import com.java.pharmacy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    final private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts   () {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }


    public Product getOneProduct(long id){
        return productRepository.findById(id).orElseThrow();
    }
    // create
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // update
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
    // delete

    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }
}
