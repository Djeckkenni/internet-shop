package mate.acadamy.internetshop;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import mate.acadamy.internetshop.inject.Injector;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.service.ProductService;

public class Application {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException,
            ClassNotFoundException {

        Product jeans = new Product();
        jeans.setProductId((long) 0);
        jeans.setProductName("Diesel");
        jeans.setProductPrice(BigDecimal.valueOf(450));

        Injector injector = Injector.getInstance("mate.acadamy.internetshop");
        ProductService productService = (ProductService) Injector.getInstance(ProductService.class);

        productService.create(jeans);

        Product boots = new Product();
        boots.setProductId((long) 1);
        boots.setProductName("Tommy");
        boots.setProductPrice(BigDecimal.valueOf(250));

        productService.create(boots);

        Product jacket = new Product();
        jacket.setProductId((long) 2);
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
    }
}


