package mate.acadamy.internetshop.dao.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.acadamy.internetshop.dao.ProductDao;
import mate.acadamy.internetshop.dao.lib.Dao;
import mate.acadamy.internetshop.exceptions.DataProcessingException;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.util.ConnectionUtil;

@Dao
public class ProductDaoJdbcImpl implements ProductDao {
    @Override
    public Product create(Product element) {
        Connection connection = ConnectionUtil.getConnection();
        String query = "INSERT INTO products (productName, productPrice) values(?, ?)";
        try (PreparedStatement statement = connection
                .prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, element.getProductName());
            statement.setBigDecimal(2, element.getProductPrice());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                element.setProductId(resultSet.getLong("product_id"));
            }
            return element;
        } catch (SQLException e) {
            throw new DataProcessingException("Product didn't created", e);
        }
    }

    @Override
    public Optional<Product> get(Long id) {
        Connection connection = ConnectionUtil.getConnection();
        String query = "SELECT * from products where product_id=?;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getProductFromResultSet(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Getting of product with id="
                    + id + " is failed", e);
        }
    }

    @Override
    public List<Product> getAll() {
        Connection connection = ConnectionUtil.getConnection();
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                products.add(getProductFromResultSet(resultSet));
            }
            return products;
        } catch (SQLException e) {
            throw new DataProcessingException("Getting of list of products is failed", e);
        }
    }

    @Override
    public Product update(Product element) {
        Connection connection = ConnectionUtil.getConnection();
        String query = "UPDATE products SET name=?, price=? WHERE product_id=?;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, element.getProductName());
            statement.setBigDecimal(2, element.getProductPrice());
            statement.setLong(3, element.getProductId());
            statement.executeUpdate();
            return element;
        } catch (SQLException e) {
            throw new DataProcessingException("Update of product with id="
                    + element.getProductId() + " is failed", e);
        }
    }

    @Override
    public boolean delete(Long id) {
        Connection connection = ConnectionUtil.getConnection();
        String query = "DELETE FROM products WHERE product_id=?;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DataProcessingException("Delete of product with id="
                    + id + " is failed", e);
        }
    }

    public Product getProductFromResultSet(ResultSet resultSet) throws SQLException {
        Long productId = resultSet.getLong("product_id");
        String productName = resultSet.getString("product_name");
        BigDecimal productPrice = resultSet.getBigDecimal("product_price");
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        return product;
    }
}
