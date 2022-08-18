package de.danilova;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private Cart cart;
    private ProductService productService;

    @Autowired
    public CartService(Cart cart, ProductService productService) {
        this.cart = cart;
        this.productService= productService;
    }

    public void add(Product product){
        cart.add(product);
    }

    public void removeById(Product product){
        cart.removeById(product.getId());
    }

    public Cart getCart() {
        return cart;
    }
}
