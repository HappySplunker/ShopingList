package com.rsamarskyi.shopinglist.views;

import com.rsamarskyi.shopinglist.services.AddNewProductService;

import java.util.Scanner;

public class AddNewProductView {

    private AddNewProductService addNewProductService;

    public AddNewProductView(AddNewProductService addNewProductService) {
        this.addNewProductService = addNewProductService;
    }

    public void action(){
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product title");
        String title = scanner.nextLine();
        System.out.println("Enter product description");
        String description = scanner.nextLine();

        addNewProductService.add(title, description);
        System.out.println("Product " + title + " was added to list");
        System.out.println();
    }
}
