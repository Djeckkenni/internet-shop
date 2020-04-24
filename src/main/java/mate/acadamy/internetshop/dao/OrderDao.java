package mate.acadamy.internetshop.dao;

import java.util.List;
import java.util.Optional;
import mate.acadamy.internetshop.model.Order;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.model.User;

public interface OrderDao {
    Order create(List<Product> products, User user);

    Optional<Order> get(Long orderId);

    List<Order> getUserOrders(Long userId);

    Order update(Order order);

    boolean delete(Long orderId);

    boolean delete(Order order);

    List<Order> getAll();
}
