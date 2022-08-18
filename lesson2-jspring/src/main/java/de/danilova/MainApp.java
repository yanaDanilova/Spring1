package de.danilova;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepository productRepository = context.getBean(ProductRepository.class);
        CartService cartService = context.getBean(CartService.class);


        showAllProduct(productRepository);
        Scanner scanner= new Scanner(System.in);
        int productId = scanner.nextInt();

        addProductToTheCard(productId,cartService,productRepository);

        showCart(cartService);

        boolean isTrue = true;

        while (isTrue){
            System.out.println("Enter /add or /delete or /show or /close");
            String command = scanner.next();

            if(command.equals("/show")){
                showCart(cartService);
            }
            if(command.equals("/close")){
                isTrue = false;
                scanner.close();
            }
            if(command.equals("/add")) {
                System.out.println("Enter id");
                int id = scanner.nextInt();
                addProductToTheCard(id, cartService, productRepository);
            }
            if(command.equals("/delete")){
                System.out.println("Enter id");
                int id = scanner.nextInt();
                deleteFromCurrentCart(id,cartService);
            }

        }
    }



    public static void showCart(CartService cartService){
        System.out.println( "In you cart: "+cartService.getCart().getProducts());
    }
    public static void showAllProduct(ProductRepository productRepository){
        System.out.println("Products: "+productRepository.getAllProductList());
        System.out.println("What would you like to add to the cart? Enter ID");
    }
    public static void addProductToTheCard(int id, CartService cartService, ProductRepository productRepository){
        cartService.add(productRepository.findProductById(id).get());

    }
    public static void deleteFromCurrentCart(int id, CartService cartService){
        cartService.getCart().removeById(id);
    }
}
