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
import mate.acadamy.internetshop.dao.OrderDao;
import mate.acadamy.internetshop.dao.lib.Dao;
import mate.acadamy.internetshop.exceptions.DataProcessingException;
import mate.acadamy.internetshop.model.Order;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.util.ConnectionUtil;

@Dao
public class OrderDaoJdbcImpl implements OrderDao {
    @Override
    public Order create(Order order) {
        String query = "INSERT INTO internet_shop.orders (user_id) VALUES(?);";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, order.getUserId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                order.setOrderId(resultSet.getLong(1));
            }
            addProductsToOrder(order);
            return order;
        } catch (SQLException e) {
            throw new DataProcessingException("Creation of order is failed", e);
        }
    }

    @Override
    public Optional<Order> get(Long id) {
        String query = "SELECT * FROM internet_shop.orders WHERE order_id=?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getOrderFromResultSet(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Getting of order with id="
                    + id + " is failed", e);
        }
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM internet_shop.orders;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(getOrderFromResultSet(resultSet));
            }
            return orders;
        } catch (SQLException e) {
            throw new DataProcessingException("Getting of list of orders is failed", e);
        }
    }

    @Override
    public Order update(Order order) {
        deleteProductsFromOrder(order.getOrderId());
        addProductsToOrder(order);
        return order;
    }

    @Override
    public boolean delete(Long id) {
        String query = "DELETE FROM internet_shop.orders WHERE order_id=?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            deleteProductsFromOrder(id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DataProcessingException("Delete of order with id="
                    + id + " is failed", e);
        }
    }

    private void addProductsToOrder(Order order) {
        String query = "INSERT INTO internet_shop.orders_products(order_id, product_id) "
                + "VALUES(?,?);";
        try (Connection connection = ConnectionUtil.getConnection()) {
            for (Product product : order.getProducts()) {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setLong(1, order.getOrderId());
                statement.setLong(2, product.getProductId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add products to order", e);
        }
    }

    private Order getOrderFromResultSet(ResultSet resultSet) throws SQLException {
        Long orderId = resultSet.getLong("order_id");
        Long userId = resultSet.getLong("user_id");
        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(userId);
        order.setProducts(getProductsOfOrder(orderId));
        return order;
    }

    private List<Product> getProductsOfOrder(Long orderId) {
        String query = "SELECT products.product_id, products.name, products.price "
                + "FROM orders_products INNER JOIN products "
                + "ON  orders_products.product_id=products.product_id \n"
                + "WHERE orders_products.order_id = ?;";
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long productId = resultSet.getLong("product_id");
                String name = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                Product product = new Product();
                product.setProductId(productId);
                product.setProductName(name);
                product.setProductPrice(price);
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get list of products of order", e);
        }
    }

    private void deleteProductsFromOrder(Long orderId) {
        String query = "DELETE FROM internet_shop.orders_products WHERE order_id=?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, orderId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete products from order", e);
        }
    }
}
