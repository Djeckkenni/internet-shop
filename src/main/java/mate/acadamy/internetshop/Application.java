package mate.acadamy.internetshop;

import mate.acadamy.internetshop.dao.Injector;
import mate.acadamy.internetshop.dao.Storage;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.service.ItemService;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public class Application {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Injector injector = Injector.getInstance("mate.acadamy.internetshop");
        ItemService itemService = (ItemService) Injector.getInstance(ItemService.class);
        Product jeans = new Product();
        jeans.setItemId((long) 0);
        jeans.setItemName("Diesel");
        jeans.setItemPrice(BigDecimal.valueOf(450));

        Product boots = new Product();
        boots.setItemId((long) 1);
        boots.setItemName("Tommy");
        boots.setItemPrice(BigDecimal.valueOf(250));

        Product jacket = new Product();
        jacket.setItemId((long) 2);
        jacket.setItemName("Zara");
        jacket.setItemPrice(BigDecimal.valueOf(100));

        itemService.create(jeans);
        itemService.create(jacket);
        itemService.create(boots);
        System.out.println(Storage.items.toString());

        Product newJacket = new Product();
        jacket.setItemId((long) 2);
        jacket.setItemName("Gap");
        jacket.setItemPrice(BigDecimal.valueOf(150));
        itemService.update(newJacket);
        System.out.println(Storage.items.toString());

        itemService.delete(boots);
        System.out.println(Storage.items.toString());
    }
}

