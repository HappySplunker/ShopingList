package com.rsamarskyi.shopinglist.services;

import com.rsamarskyi.shopinglist.db.Database;
import com.rsamarskyi.shopinglist.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowAllProductsService {

    private Database database;

    public ShowAllProductsService(Database database) {
        this.database = database;
    }

    public List<Product> getAllProductsInList(){
        return database.getAllProducts();
    }
}
