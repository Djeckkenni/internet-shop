package mate.acadamy.internetshop.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import mate.acadamy.internetshop.dao.ShoppingCartDao;
import mate.acadamy.internetshop.dao.lib.Dao;
import mate.acadamy.internetshop.db.Storage;
import mate.acadamy.internetshop.model.ShoppingCart;

@Dao
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        Storage.addShoppingCart(shoppingCart);
        return shoppingCart;
    }

    @Override
    public Optional<ShoppingCart> get(Long shoppingCartId) {
        return Storage.shoppingCarts.stream()
                .filter(shoppingCart -> shoppingCart.getShoppingCartId().equals(shoppingCartId))
                .findFirst();
    }

    @Override
    public Optional<ShoppingCart> getByUserId(Long userId) {
        return Storage.shoppingCarts.stream()
                .filter(shoppingCart -> shoppingCart.getUser().getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        IntStream.range(0, Storage.shoppingCarts.size())
                .filter(index -> Storage.shoppingCarts.get(index).getShoppingCartId()
                        .equals(shoppingCart.getShoppingCartId()))
                .forEach(index -> Storage.shoppingCarts.set(index, shoppingCart));
        return shoppingCart;
    }

    @Override
    public boolean delete(Long shoppingCartId) {
        return Storage.shoppingCarts.removeIf(shoppingCart -> shoppingCart
                .getShoppingCartId().equals(shoppingCartId));
    }

    @Override
    public boolean delete(ShoppingCart shoppingCart) {
        return Storage.shoppingCarts.remove(shoppingCart);
    }

    @Override
    public List<ShoppingCart> getAll() {
        return Storage.shoppingCarts;
    }
}
