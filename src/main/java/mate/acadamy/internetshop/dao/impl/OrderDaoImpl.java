package mate.acadamy.internetshop.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import mate.acadamy.internetshop.dao.OrderDao;
import mate.acadamy.internetshop.db.Storage;
import mate.acadamy.internetshop.model.Order;

public class OrderDaoImpl implements OrderDao {
    @Override
    public Order create(Order order) {
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
    public List<Order> getAll() {
        return Storage.orders;
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
}
