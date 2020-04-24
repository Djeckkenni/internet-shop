package mate.acadamy.internetshop.db;

import java.util.ArrayList;
import java.util.List;
import mate.acadamy.internetshop.model.Bucket;
import mate.acadamy.internetshop.model.Order;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.model.User;

public class Storage {
    public static Long productId = 0L;
    public static Long userId = 0L;
    public static Long bucketId = 0L;
    public static Long orderId = 0L;
    public static final List<Product> products = new ArrayList<>();
    public static final List<User> users = new ArrayList<>();
    public static final List<Bucket> buckets = new ArrayList<>();
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

    public static void addBucket(Bucket bucket) {
        bucketId++;
        bucket.setBucketId(bucketId);
        buckets.add(bucket);
    }

    public static void addOrder(Order order) {
        orderId++;
        order.setOrderId(orderId);
        orders.add(order);
    }
}
