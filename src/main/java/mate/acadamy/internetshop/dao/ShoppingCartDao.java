package mate.acadamy.internetshop.dao;

import java.util.List;
import java.util.Optional;
import mate.acadamy.internetshop.model.ShoppingCart;

public interface ShoppingCartDao {
    ShoppingCart create(ShoppingCart shoppingCart);

    Optional<ShoppingCart> get(Long shoppingCartId);

    Optional<ShoppingCart> getByUserId(Long userId);

    ShoppingCart update(ShoppingCart shoppingCart);

    boolean delete(Long shoppingCartId);

    boolean delete(ShoppingCart shoppingCart);

    List<ShoppingCart> getAll();
}
