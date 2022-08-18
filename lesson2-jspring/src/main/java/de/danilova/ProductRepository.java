package de.danilova;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init(){
        this.productList = new ArrayList<>();
        productList.add(new Product(1,"T-Shirt", 25));
        productList.add(new Product(2,"Dress", 150));
        productList.add(new Product(3,"Jeans", 80));
        productList.add(new Product(4, "Sneakers", 120));
        productList.add(new Product(5,"Jacket", 250));
    }

    public List<Product> getAllProductList(){
        return Collections.unmodifiableList(productList);
    }

    public Optional<Product> findProductById(int id){
        return productList.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst();
    }
}
