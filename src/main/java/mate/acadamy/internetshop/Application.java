package mate.acadamy.internetshop;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;
import mate.acadamy.internetshop.inject.Injector;
import mate.acadamy.internetshop.model.Order;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.model.ShoppingCart;
import mate.acadamy.internetshop.model.User;
import mate.acadamy.internetshop.service.OrderService;
import mate.acadamy.internetshop.service.ProductService;
import mate.acadamy.internetshop.service.ShoppingCartService;
import mate.acadamy.internetshop.service.UserService;

public class Application {
    private static final Injector INJECTOR = Injector.getInstance("mate.acadamy.internetshop");

    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException,
            ClassNotFoundException {
        System.out.println("PRODUCT");
        System.out.println("-------");
        System.out.println("Initialized and created product boot, jeans, jacket, watch:");
        ProductService productService = (ProductService) INJECTOR.getInstance(ProductService.class);
        Product product1 = new Product();
        product1.setProductName("boot");
        product1.setProductPrice(new BigDecimal(500));
        productService.create(product1);
        System.out.println(product1.toString());

        Product product2 = new Product();
        product2.setProductName("jeans");
        product2.setProductPrice(new BigDecimal(300));
        productService.create(product2);
        System.out.println(product2.toString());

        Product product3 = new Product();
        product3.setProductName("jacket");
        product3.setProductPrice(new BigDecimal(400));
        productService.create(product3);
        System.out.println(product3.toString());

        Product product4 = new Product();
        product4.setProductName("watch");
        product4.setProductPrice(new BigDecimal(1000));
        productService.create(product4);
        System.out.println(product4.toString());

        System.out.println("");
        System.out.println("Get product by ID: " + productService.get(2L));
        System.out.println("");
        System.out.println("Get all products from data base: " + productService.getAll());
        System.out.println("");
        Product product = productService.get(1L);
        product.setProductPrice(new BigDecimal(450));
        System.out.println("Update product with ID = 1 and delete product with ID = 3: "
                + productService.update(product) + ", " + productService.delete(3L));
        System.out.println("");
        System.out.println("Get all products from data base: ");
        System.out.println(productService.getAll());
        System.out.println("");

        System.out.println("USER");
        System.out.println("----");
        System.out.println("Initialized and created users Tom, Bob, Sue, Marry:");
        UserService userService = (UserService) INJECTOR.getInstance(UserService.class);

        User user1 = new User();
        user1.setUserName("Tom");
        userService.create(user1);
        System.out.println(user1.toString());
        System.out.println("Get shoppingCart for user " + user1.getUserName() + ":");
        ShoppingCartService shoppingCartService = (ShoppingCartService) INJECTOR
                .getInstance(ShoppingCartService.class);
        ShoppingCart shopCartByUser1 = shoppingCartService.getByUserId(user1.getUserId());
        System.out.println(shopCartByUser1);
        System.out.println("Add products to the shoppingCart for user "
                + user1.getUserName() + ":");
        List<Product> listForUser1 = shoppingCartService.getAllProducts(shopCartByUser1);
        listForUser1.add(product1);
        listForUser1.add(product2);
        listForUser1.add(product3);
        listForUser1.add(product4);
        System.out.println(shopCartByUser1);
        System.out.println("Product list for " + user1.getUserName() + ":");
        System.out.println(listForUser1.toString());
        System.out.println("Delete products with id = 2 from the shoppingCart for user "
                + user1.getUserName() + ":");
        shoppingCartService.deleteProduct(shopCartByUser1, product4);
        System.out.println(shopCartByUser1);
        OrderService orderService = (OrderService) INJECTOR.getInstance(OrderService.class);
        Order firstOrderForUser1 = orderService.completeOrder(listForUser1, user1);
        System.out.println("Complete " + user1.getUserName() + " order and clear shoppingCart");
        System.out.println(firstOrderForUser1);
        System.out.println("");

        User user2 = new User();
        user2.setUserName("Bob");
        userService.create(user2);
        System.out.println(user2.toString());

        User user3 = new User();
        user3.setUserName("Sue");
        userService.create(user3);
        System.out.println(user3.toString());

        User user4 = new User();
        user4.setUserName("Marry");
        userService.create(user4);
        System.out.println(user4.toString());

        System.out.println("");
        System.out.println("Get user by ID: " + userService.get(2L));
        System.out.println("");
        System.out.println("Get all users from data base: " + userService.getAll());
        System.out.println("");
        User user = userService.get(1L);
        user.setUserName("New Tom");
        System.out.println("Update user with ID = 1 and delete user with ID = 3: "
                + userService.update(user) + ", " + userService.delete(3L));
        System.out.println("");
        System.out.println("Get all users from data base: ");
        System.out.println(userService.getAll());
        System.out.println("");
    }
}



