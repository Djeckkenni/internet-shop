package mate.acadamy.internetshop.service;

import mate.acadamy.internetshop.model.Order;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.model.User;

import java.util.List;

public interface OrderService {
    Order completeOrder(List<Product> products, User user);

    Order get(Long orderId);

    List<Order> getUserOrders(User user);

    List<Order> getAll();

    boolean delete(Long orderId);
}
