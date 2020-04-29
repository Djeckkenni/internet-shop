package mate.acadamy.internetshop;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import mate.acadamy.internetshop.inject.Injector;
import mate.acadamy.internetshop.model.Product;
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
        var productService = (ProductService) INJECTOR.getInstance(ProductService.class);
        var product1 = new Product();
        product1.setProductName("boot");
        product1.setProductPrice(new BigDecimal(500));
        productService.create(product1);
        System.out.println(product1.toString());
        var product2 = new Product();
        product2.setProductName("jeans");
        product2.setProductPrice(new BigDecimal(300));
        productService.create(product2);
        System.out.println(product2.toString());
        var product3 = new Product();
        product3.setProductName("jacket");
        product3.setProductPrice(new BigDecimal(400));
        productService.create(product3);
        System.out.println(product3.toString());
        var product4 = new Product();
        product4.setProductName("watch");
        product4.setProductPrice(new BigDecimal(1000));
        productService.create(product4);
        System.out.println(product4.toString());
        System.out.println("");
        System.out.println("Get product by ID: " + productService.get(2L));
        System.out.println("Get all products from data base: " + productService.getAll());
        var product = productService.get(1L);
        product.setProductPrice(new BigDecimal(400));
        System.out.println("Update product with ID = 1 and delete product with ID = 3: "
                + productService.update(product) + ", " + productService.delete(3L));
        System.out.println("Get all products from data base: ");
        System.out.println(productService.getAll());
        System.out.println("");

        System.out.println("USER");
        System.out.println("----");
        System.out.println("Initialized and created users Tom:");
        var userService = (UserService) INJECTOR.getInstance(UserService.class);

        User user1 = new User();
        user1.setUserName("Tom");
        userService.create(user1);
        System.out.println(user1.toString());
        System.out.println("");
        System.out.println("Create shopping cart for " + user1.getUserName() + ":");

        var shoppingCartService = (ShoppingCartService)
                INJECTOR.getInstance(ShoppingCartService.class);
        var shoppingCartServiceForUser1 = shoppingCartService
                .getByUserId(user1.getUserId());
        System.out.println(shoppingCartServiceForUser1);

        System.out.println("Added product to the " + user1.getUserName() + " shopping cart:");
        shoppingCartService.addProduct(shoppingCartServiceForUser1,product1);
        shoppingCartService.addProduct(shoppingCartServiceForUser1,product2);
        shoppingCartService.addProduct(shoppingCartServiceForUser1,product3);
        shoppingCartService.addProduct(shoppingCartServiceForUser1,product4);
        System.out.println(shoppingCartServiceForUser1);
        System.out.println("Delete product \"watch\" from the "
                + user1.getUserName() + " shopping cart:");
        shoppingCartService.deleteProduct(shoppingCartServiceForUser1, product4);
        System.out.println(shoppingCartServiceForUser1);
        System.out.println("Get all products from the " + user1.getUserName() + " shopping cart:");
        System.out.println(shoppingCartService.getAllProducts(shoppingCartServiceForUser1));
        System.out.println("");

        System.out.println("ShoppingCart before complete:");
        System.out.println(shoppingCartServiceForUser1);
        var orderService = (OrderService) INJECTOR.getInstance(OrderService.class);
        var orderForShCartUser1 = orderService.completeOrder(shoppingCartService
                .getAllProducts(shoppingCartServiceForUser1), user1);
        System.out.println("Create first order for " + user1.getUserName());
        System.out.println(orderForShCartUser1);
        System.out.println("ShoppingCart after complete:");
        System.out.println(shoppingCartServiceForUser1);

        System.out.println("Create second order for " + user1.getUserName());
        shoppingCartService.addProduct(shoppingCartServiceForUser1,product1);
        shoppingCartService.addProduct(shoppingCartServiceForUser1,product2);
        var orderForShCartUser2 = orderService.completeOrder(shoppingCartService
                .getAllProducts(shoppingCartServiceForUser1), user1);
        System.out.println(orderForShCartUser2);

        System.out.println("Get order by id:");
        System.out.println(orderService.get(1L));
        System.out.println("Get user orders:");
        System.out.println(orderService.getUserOrders(user1));
        System.out.println("Get all orders:");
        System.out.println(orderService.getAll());
        System.out.println("Delete second order:");
        orderService.delete(2L);
        System.out.println(orderService.getUserOrders(user1));
        System.out.println("");

        System.out.println("Initialized and created users Bob, Sue, Marry:");
        var user2 = new User();
        user2.setUserName("Bob");
        userService.create(user2);
        System.out.println(user2.toString());
        var user3 = new User();
        user3.setUserName("Sue");
        userService.create(user3);
        System.out.println(user3.toString());
        var user4 = new User();
        user4.setUserName("Marry");
        userService.create(user4);
        System.out.println(user4.toString());
        System.out.println("Get user by ID: " + userService.get(2L));
        System.out.println("Get all users from data base: " + userService.getAll());
        var user = userService.get(1L);
        user.setUserName("New Tom");
        System.out.println("Update user with ID = 1 and delete user with ID = 3: "
                + userService.update(user) + ", " + userService.delete(3L));
        System.out.println("Get all users from data base: ");
        System.out.println(userService.getAll());
    }
}



