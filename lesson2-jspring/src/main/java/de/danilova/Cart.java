package de.danilova;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "prototype")
public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void add(Product product){
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void removeById(int id){
        products.removeIf(product -> product.getId()==id);
    }
}
