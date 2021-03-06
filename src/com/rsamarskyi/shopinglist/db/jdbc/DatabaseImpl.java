package com.rsamarskyi.shopinglist.db.jdbc;

import com.rsamarskyi.shopinglist.db.Database;
import com.rsamarskyi.shopinglist.domain.Product;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DatabaseImpl
        extends JDBCRepository
        implements Database {

    @Override
    public void addProduct(Product product) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "insert into PRODUCTS(id, title, description) values(default, ?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setString(2, product.getDescription());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                product.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute ProductDAOImpl.save()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Optional<Product> findProductByTitle(String title) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from PRODUCTS where title = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product = null;
            if (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setTitle(resultSet.getString("title"));
                product.setDescription(resultSet.getString("description"));
            }
            return Optional.ofNullable(product);
        } catch (Throwable e) {
            System.out.println("Exception while execute ProductDAOImpl.getByTitle()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public boolean deleteProduct(Product product) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "delete from PRODUCTS where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, product.getId());
            int numOfRowsDeleted = preparedStatement.executeUpdate();
            return numOfRowsDeleted == 1;
        } catch (Throwable e) {
            System.out.println("Exception while execute ProductDAOImpl.delete()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "select * from PRODUCTS";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setTitle(resultSet.getString("title"));
                product.setDescription(resultSet.getString("description"));
                products.add(product);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list ProductDAOImpl.getAll()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
        return products;
    }

}
