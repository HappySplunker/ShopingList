package com.rsamarskyi.shopinglist.services;

import com.rsamarskyi.shopinglist.db.Database;
import com.rsamarskyi.shopinglist.domain.Product;

public class AddNewProductService {


    private Database database;

    public AddNewProductService(Database database) {
        this.database = database;
    }

    public void add (String title, String description){
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);

        database.addProduct(product);
    }

}
