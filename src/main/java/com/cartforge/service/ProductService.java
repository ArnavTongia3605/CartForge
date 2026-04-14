package com.cartforge.service;

import com.cartforge.model.Product;
import com.cartforge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        if(product == null){
            throw new RuntimeException("Product cannot be null");
        }

        if(product.getPrice() <= 0){
            throw new RuntimeException("Price must be positive");
        }

        if(product.getStock() < 0){
            throw new RuntimeException("Stock cannot be negative");
        }
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Long id, Product updated) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(updated.getName());
        product.setDescription(updated.getDescription());
        product.setPrice(updated.getPrice());
        product.setStock(updated.getStock());

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}