package mate.acadamy.internetshop.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import mate.acadamy.internetshop.dao.OrderDao;
import mate.acadamy.internetshop.dao.lib.Dao;
import mate.acadamy.internetshop.db.Storage;
import mate.acadamy.internetshop.model.Order;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.model.User;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order create(List<Product> products, User user) {
        Order order = new Order();
        order.setProducts(products);
        order.setUser(user);
        Storage.addOrder(order);
        return order;
    }

    @Override
    public Optional<Order> get(Long orderId) {
        return Storage.orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst();
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        return Storage.orders.stream()
                .filter(order -> order.getUser().getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public Order update(Order order) {
        IntStream.range(0, Storage.orders.size())
                .filter(index -> Storage.orders.get(index).getOrderId().equals(order.getOrderId()))
                .forEach(index -> Storage.orders.set(index, order));
        return order;
    }

    @Override
    public boolean delete(Long orderId) {
        return Storage.orders.removeIf(order -> order.getOrderId().equals(orderId));
    }

    @Override
    public boolean delete(Order order) {
        return Storage.orders.remove(order);
    }

    @Override
    public List<Order> getAll() {
        return Storage.orders;
    }
}
