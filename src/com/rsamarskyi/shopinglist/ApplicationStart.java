package com.rsamarskyi.shopinglist;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ApplicationStart {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        while(true){
            getUserMenuInput();
            int userChoice = getUserChoice();
            if (userChoice == 4){
                break;
            }
            switch(userChoice){
                case 1:{
                   addProductToList(products);
                   break;
                }
                case 2:{
                    removeProductFromList(products);
                    break;
                }
                case 3:{
                    printProductList(products);
                    break;
                }
                default:
                    System.out.println("Wrong option. Try again");
            }
        }
    }
    private static void addProductToList(List<Product> products){
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product title");
        String title = sc.nextLine();
        System.out.println("Enter product description");
        String description = sc.nextLine();
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        products.add(product);
        System.out.println("Product " + product.getTitle() + " was added to list");
        System.out.println();
        //sc.close();

    }

    private static void removeProductFromList(List<Product> products){
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product you want to remove");
        String title = sc.nextLine();
        Optional<Product> foundProduct = products.stream()
                .filter(p -> p.getTitle().equals(title))
                .findFirst();
        if(foundProduct.isPresent()){
            Product product = foundProduct.get();
            products.remove(product);
            System.out.println("Product " + title + " was removed");
        }else
            System.out.println("Can not find product with title " + title);
        System.out.println();
    }

    private static void printProductList(List<Product> products){
        System.out.println();
        for(Product product : products){
            System.out.println(product.getTitle() + " [ " + product.getDescription() + " ]");
        }
        System.out.println();


    }

    private static void getUserMenuInput (){
        System.out.println("Press 1 to add product to the list");
        System.out.println("Press 2 to remove product from the list");
        System.out.println("Press 3 to show the list");
        System.out.println("Press 4 to exit");
    }
    private static int getUserChoice(){
        System.out.println("Enter your choice");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
}
