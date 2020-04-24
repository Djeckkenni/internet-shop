package mate.acadamy.internetshop.service.impl;

import java.util.List;
import mate.acadamy.internetshop.dao.ShoppingCartDao;
import mate.acadamy.internetshop.db.Storage;
import mate.acadamy.internetshop.inject.lib.Inject;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.model.ShoppingCart;
import mate.acadamy.internetshop.service.ShoppingCartService;
import mate.acadamy.internetshop.service.lib.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Inject
    private ShoppingCartDao shoppingCartDao;

    @Override
    public ShoppingCart addProduct(ShoppingCart shoppingCart, Product product) {
        shoppingCartDao.create(shoppingCart);
        shoppingCart.getProducts().add(product);
        return shoppingCartDao.update(shoppingCart);
    }

    @Override
    public boolean deleteProduct(ShoppingCart shoppingCart, Product product) {
        if (shoppingCart.getProducts().removeIf(product1 -> product.getProductId()
                .equals(product1.getProductId()))) {
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
        return shoppingCartDao.getByUserId(userId).get();
    }

    @Override
    public List<Product> getAllProducts(ShoppingCart shoppingCart) {
        return Storage.shoppingCarts
                .stream()
                .filter(cart -> cart.getShoppingCartId().equals(shoppingCart.getShoppingCartId()))
                .findFirst().get().getProducts();
    }
}
