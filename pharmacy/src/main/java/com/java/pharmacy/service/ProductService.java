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

    public Optional<Product> getProductByID(Long id) {
        return productRepository.findById(id);
    }

//hniuygygigyhgyugygyigiguiguigui
    public Product getOneProduct(long id){
        return productRepository.findById(id).orElseThrow();
    }
    // create
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // update
    public Product updateProduct(long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        return productRepository.save(product);

    }
    // delete

    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }
}
