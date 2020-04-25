package mate.acadamy.internetshop.service;

import java.util.List;
import mate.acadamy.internetshop.model.Order;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.model.User;

public interface OrderService {
    Order completeOrder(List<Product> products, User user);

    Order get(Long id);

    List<Order> getUserOrders(User user);

    List<Order> getAll();

    boolean delete(Long id);
}
