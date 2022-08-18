package de.danilova;

import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(int id) {
        return productRepository. findProductById(id);
    }
}
