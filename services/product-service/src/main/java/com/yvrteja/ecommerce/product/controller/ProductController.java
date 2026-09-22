package com.yvrteja.ecommerce.product.controller;

import com.yvrteja.ecommerce.product.model.Product;
import com.yvrteja.ecommerce.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET /api/v1/products
    // Returns all products.
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // GET /api/v1/products/{id}
    // Returns one product by ID.
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    // PUT /api/v1/products/{id}
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,@RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
    // DELETE /api/v1/products/{id}
    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}