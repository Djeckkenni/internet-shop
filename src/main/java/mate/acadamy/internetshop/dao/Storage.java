package mate.acadamy.internetshop.dao;

import mate.acadamy.internetshop.model.Bucket;
import mate.acadamy.internetshop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static Long itemId = 0L;
    public static final List<Product> items = new ArrayList<>();
    public static final List<Bucket> buckets = new ArrayList<>();

    public static void addItem(Product item){
        itemId ++;
        item.setItemId(itemId);
        items.add(item);
    }
}
