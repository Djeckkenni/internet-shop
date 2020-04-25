package mate.acadamy.internetshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mate.acadamy.internetshop.dao.OrderDao;
import mate.acadamy.internetshop.inject.lib.Inject;
import mate.acadamy.internetshop.model.Order;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.model.User;
import mate.acadamy.internetshop.service.OrderService;
import mate.acadamy.internetshop.service.ShoppingCartService;
import mate.acadamy.internetshop.service.lib.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private ShoppingCartService shoppingCartService;
    @Inject
    private OrderDao orderDao;

    @Override
    public Order completeOrder(List<Product> products, User user) {
        List<Product> newListProducts = new ArrayList<>(products);
        Order order = new Order();
        order.setProducts(newListProducts);
        order.setUser(user);
        orderDao.create(order);
        shoppingCartService.clear(shoppingCartService.getByUserId(user.getUserId()));
        return order;
    }

    @Override
    public Order get(Long id) {
        return orderDao.get(id).get();
    }

    @Override
    public List<Order> getUserOrders(User user) {
        return orderDao.getAll().stream()
                .filter(order -> order.getUser().equals(user))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public boolean delete(Long id) {
        return orderDao.delete(id);
    }
}
