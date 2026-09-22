package com.yvrteja.ecommerce.product.service;

import com.yvrteja.ecommerce.product.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();
    public ProductService() {
        products.add(
                new Product(
                        1L,
                        "Laptop",
                        "Business Laptop",
                        new BigDecimal("750000.00")
                )
        );
        products.add(
                new Product(
                        2L,
                        "Wireless Mouse",
                        "Bluetooth wireless mouse",
                        new BigDecimal("1500.00")
                )
        );
    }

    public List<Product> getAllProducts() {
        return products;
    }
    public Product getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public Product createProduct(Product product) {

        // Simple ID generation for our temporary in-memory implementation.
        long nextId = products.stream()
                .mapToLong(Product::getId)
                .max()
                .orElse(0L) + 1;

        product.setId(nextId);

        products.add(product);

        return product;
    }
    public Product updateProduct(Long id, Product updatedProduct) {

        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .map(existingProduct -> {

                    // Update the existing product fields.
                    existingProduct.setName(updatedProduct.getName());
                    existingProduct.setDescription(updatedProduct.getDescription());
                    existingProduct.setPrice(updatedProduct.getPrice());

                    return existingProduct;
                })
                .orElse(null);
    }
    public boolean deleteProduct(Long id) {

        return products.removeIf(product -> product.getId().equals(id));
    }
}
