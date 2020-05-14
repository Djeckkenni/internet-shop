package mate.acadamy.internetshop.service;

import java.util.List;
import mate.acadamy.internetshop.model.Order;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.model.User;

public interface OrderService extends GenericService<Order, Long> {
    Order completeOrder(List<Product> products, Long userId);

    List<Order> getUserOrders(User user);
}
