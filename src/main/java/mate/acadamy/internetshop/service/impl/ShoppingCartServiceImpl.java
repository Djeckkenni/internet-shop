package mate.acadamy.internetshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import mate.acadamy.internetshop.dao.ShoppingCartDao;
import mate.acadamy.internetshop.dao.UserDao;
import mate.acadamy.internetshop.inject.lib.Inject;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.model.ShoppingCart;
import mate.acadamy.internetshop.model.User;
import mate.acadamy.internetshop.service.ShoppingCartService;
import mate.acadamy.internetshop.service.lib.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Inject
    private ShoppingCartDao shoppingCartDao;
    @Inject
    private UserDao userDao;

    @Override
    public ShoppingCart addProduct(ShoppingCart shoppingCart, Product product) {
        shoppingCart.getProducts().add(product);
        return shoppingCartDao.update(shoppingCart);
    }

    @Override
    public boolean deleteProduct(ShoppingCart shoppingCart, Product product) {
        if (shoppingCart.getProducts().remove(product)) {
            shoppingCartDao.update(shoppingCart);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getProducts().clear();
        shoppingCartDao.update(shoppingCart);
    }

    @Override
    public ShoppingCart getByUserId(Long userId) {
        return shoppingCartDao.getAll().stream()
                .filter(element -> element.getUser().getUserId().equals(userId))
                .findFirst()
                .orElseGet(() -> {
                    User findUser = userDao.getAll().stream()
                            .filter(user -> user.getUserId().equals(userId))
                            .findFirst().get();
                    ShoppingCart shoppingCart = new ShoppingCart();
                    shoppingCart.setUser(findUser);
                    return shoppingCartDao.create(shoppingCart);
                });
    }

    @Override
    public List<Product> getAllProducts(ShoppingCart shoppingCart) {
        return shoppingCart.getProducts();
    }
}
