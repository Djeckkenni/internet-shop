package mate.acadamy.internetshop.service.impl;

import java.util.List;

import mate.acadamy.internetshop.dao.ShoppingCartDao;
import mate.acadamy.internetshop.db.Storage;
import mate.acadamy.internetshop.inject.lib.Inject;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.model.ShoppingCart;
import mate.acadamy.internetshop.service.ShoppingCartService;
import mate.acadamy.internetshop.service.UserService;
import mate.acadamy.internetshop.service.lib.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Inject
    private ShoppingCartDao shoppingCartDao;
    @Inject
    private UserService userService;

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
        }
        return false;
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getProducts().clear();
        shoppingCartDao.update(shoppingCart);
    }

    @Override
    public ShoppingCart getByUserId(Long userId) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(getByUserId(userId).getUser());
        shoppingCart.setProducts(getByUserId(userId).getProducts());
        return shoppingCartDao.getByUserId(userId).orElseGet(() -> shoppingCartDao.create(shoppingCart));
    }

    @Override
    public List<Product> getAllProducts(ShoppingCart shoppingCart) {
        return shoppingCart.getProducts();
    }
}
