package mate.acadamy.internetshop.db;

import mate.acadamy.internetshop.model.Order;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.model.ShoppingCart;
import mate.acadamy.internetshop.model.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static Long productId = 0L;
    public static Long userId = 0L;
    public static Long shoppingCartId = 0L;
    public static Long orderId = 0L;
    public static final List<Product> products = new ArrayList<>();
    public static final List<User> users = new ArrayList<>();
    public static final List<ShoppingCart> shoppingCarts = new ArrayList<>();
    public static final List<Order> orders = new ArrayList<>();

    public static void addProduct(Product product) {
        productId++;
        product.setProductId(productId);
        products.add(product);
    }

    public static void addUser(User user) {
        userId++;
        user.setUserId(userId);
        users.add(user);
    }

    public static void addShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartId++;
        shoppingCart.setShoppingCartId(shoppingCartId);
        shoppingCarts.add(shoppingCart);
    }

    public static void addOrder(Order order) {
        orderId++;
        order.setOrderId(orderId);
        orders.add(order);
    }
}
