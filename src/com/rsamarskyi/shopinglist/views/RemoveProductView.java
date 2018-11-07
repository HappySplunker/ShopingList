package com.rsamarskyi.shopinglist.views;

import com.rsamarskyi.shopinglist.services.RemoveProductService;

import java.util.Scanner;

public class RemoveProductView {
   private RemoveProductService removeProductService;

    public RemoveProductView(RemoveProductService removeProductService) {
        this.removeProductService = removeProductService;
    }

    public void action(){
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product you want to remove");
        String title = scanner.nextLine();

        boolean isRemoved = removeProductService.remove(title);

        if(isRemoved){
            System.out.println("Product " + title + " was removed");
        }else
            System.out.println("Can not find product with title " + title);
            System.out.println();

    }
}
