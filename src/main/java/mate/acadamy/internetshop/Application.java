package mate.acadamy.internetshop;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
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

        ProductService productService = null;
        System.out.println("PRODUCT");

        productService = (ProductService) INJECTOR.getInstance(ProductService.class);
        Product jeans = new Product();
        jeans.setProductName("Diesel");
        jeans.setProductPrice(BigDecimal.valueOf(450));
        productService.create(jeans);

        Product boots = new Product();
        boots.setProductName("Tommy");
        boots.setProductPrice(BigDecimal.valueOf(250));
        productService.create(boots);

        Product jacket = new Product();
        jacket.setProductName("Zara");
        jacket.setProductPrice(BigDecimal.valueOf(100));
        productService.create(jacket);

        System.out.println("Create method and getAll method");
        System.out.println(productService.getAll());
        System.out.println("");

        System.out.println("Update method and get by id method, getAll method");
        Product newJacket = new Product();

        productService.update(newJacket);

        jacket.setProductId((long) 2);
        jacket.setProductName("Gap");
        jacket.setProductPrice(BigDecimal.valueOf(150));
        System.out.println(productService.get(1L));
        System.out.println(productService.getAll());
        System.out.println("");

        System.out.println("Delete by object method and getAll method");
        productService.delete(boots);
        System.out.println(productService.getAll());
        System.out.println("");

        System.out.println("Delete by id method and getAll method");
        productService.delete(2L);
        System.out.println(productService.getAll());

        UserService userService = null;
        System.out.println("USER");

        userService = (UserService) INJECTOR.getInstance(UserService.class);
        User user1 = new User();
        user1.setUserName("Bob");
        userService.create(user1);

        User user2 = new User();
        user2.setUserName("Sue");
        userService.create(user2);

        User user3 = new User();
        user3.setUserName("Tom");
        userService.create(user3);

        System.out.println("Create method and getAll method");
        System.out.println(userService.getAll());
        System.out.println("");

        System.out.println("Update method and get by id method, getAll method");
        User user4 = new User();
        userService.update(user4);
        user4.setUserId(2L);
        user3.setUserName("Marry");
        userService.create(user4);
        System.out.println(userService.get(1L));
        System.out.println(userService.getAll());
        System.out.println("");

        System.out.println("Delete by id method and getAll method");
        userService.delete(2L);
        System.out.println(userService.getAll());

        OrderService orderService = null;
        System.out.println("ORDER");

        orderService = (OrderService) INJECTOR.getInstance(OrderService.class);
        List<Product> listOrder1 = new ArrayList<>();
        listOrder1.add(jeans);
        orderService.completeOrder(listOrder1, user1);

        List<Product> listOrder2 = new ArrayList<>();
        listOrder2.add(boots);
        orderService.completeOrder(listOrder2, user2);

        List<Product> listOrder3 = new ArrayList<>();
        listOrder3.add(jacket);
        orderService.completeOrder(listOrder3, user3);

        System.out.println("Create method and getAll method");
        System.out.println(orderService.getAll());
        System.out.println("");

        System.out.println("Get user orders method");
        List<Order> userOrders = orderService.getUserOrders(user1);
        System.out.println(userOrders.toString());

        System.out.println("Delete by id method and getAll method");
        orderService.delete(2L);
        System.out.println(orderService.getAll());

        ShoppingCartService shoppingCartService = null;
        System.out.println("SHOPPINGCART");

        shoppingCartService = (ShoppingCartService) INJECTOR.getInstance(ShoppingCartService.class);
        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setProducts(listOrder1);
        shoppingCart1.setUser(user1);
        shoppingCartService.addProduct(shoppingCart1, jeans);
        shoppingCartService.addProduct(shoppingCart1, jacket);

        ShoppingCart shoppingCart2 = new ShoppingCart();
        shoppingCart2.setProducts(listOrder2);
        shoppingCart2.setUser(user2);
        shoppingCartService.addProduct(shoppingCart2, boots);
        shoppingCartService.addProduct(shoppingCart1, jacket);

        ShoppingCart shoppingCart3 = new ShoppingCart();
        shoppingCart3.setProducts(listOrder3);
        shoppingCart3.setUser(user3);
        shoppingCartService.addProduct(shoppingCart3, boots);
        shoppingCartService.addProduct(shoppingCart3, jeans);

        System.out.println("Add method and getAllProducts");
        System.out.println("First shopping cart : "
                + shoppingCartService.getAllProducts(shoppingCart1));
        System.out.println("Second shopping cart : "
                + shoppingCartService.getAllProducts(shoppingCart2));
        System.out.println("Third shopping cart : "
                + shoppingCartService.getAllProducts(shoppingCart3));
        System.out.println("");

        System.out.println("DeleteProduct");
        shoppingCartService.deleteProduct(shoppingCart1, jeans);
        System.out.println(shoppingCart1.getProducts().toString());
    }
}



