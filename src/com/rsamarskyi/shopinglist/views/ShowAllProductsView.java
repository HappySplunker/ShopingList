package com.rsamarskyi.shopinglist.views;

import com.rsamarskyi.shopinglist.domain.Product;
import com.rsamarskyi.shopinglist.services.ShowAllProductsService;

public class ShowAllProductsView {

    private ShowAllProductsService showAllProductsService;

    public ShowAllProductsView(ShowAllProductsService showAllProductsService) {
        this.showAllProductsService = showAllProductsService;
    }

    public void action(){
        System.out.println();
        for(Product product : showAllProductsService.getAllProductsInList()){
            System.out.println(product.getTitle() + " [ " + product.getDescription() + " ]");
        }
        System.out.println();
    }
}
