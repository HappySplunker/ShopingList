package com.rsamarskyi.shopinglist.services;

import com.rsamarskyi.shopinglist.db.Database;
import com.rsamarskyi.shopinglist.domain.Product;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RemoveProductService {

    private Database database;

    public RemoveProductService(Database database) {
        this.database = database;
    }

    public boolean remove(String title){
        Optional<Product> foundProduct = database.findProductByTitle(title);
        if(foundProduct.isPresent()){
            Product product = foundProduct.get();
            return database.deleteProduct(product);
        }else {
            return false;
        }
    }
}
