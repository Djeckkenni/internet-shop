package mate.acadamy.internetshop.dao;

import java.util.List;
import java.util.Optional;
import mate.acadamy.internetshop.model.Order;

public interface OrderDao {
    Order create(Order order);

    Optional<Order> get(Long orderId);

    List<Order> getUserOrders(Long userId);

    Order update(Order order);

    boolean delete(Long orderId);

    boolean delete(Order order);

    List<Order> getAll();
}
