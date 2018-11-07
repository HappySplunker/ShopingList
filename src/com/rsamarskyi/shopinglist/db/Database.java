package com.rsamarskyi.shopinglist.db;

import com.rsamarskyi.shopinglist.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


public interface Database {
    void addProduct(Product product);

    Optional<Product> findProductByTitle(String title);

    boolean deleteProduct(Product product);

    List<Product> getAllProducts();
}
