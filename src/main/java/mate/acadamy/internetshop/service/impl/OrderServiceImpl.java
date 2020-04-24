package mate.acadamy.internetshop.service.impl;

import java.util.List;
import mate.acadamy.internetshop.dao.OrderDao;
import mate.acadamy.internetshop.dao.ProductDao;
import mate.acadamy.internetshop.dao.ShoppingCartDao;
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
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;
    @Inject
    private ShoppingCartDao shoppingCartDao;
    @Inject
    private ProductDao productDao;
    @Override
    public Order completeOrder(List<Product> products, User user) {
        Order order = new Order();
        order.setProducts(products);
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
        return orderDao.getUserOrders(user.getUserId());
    }

    @Override
    public boolean delete(Long id) {
        return orderDao.delete(id);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }
}
