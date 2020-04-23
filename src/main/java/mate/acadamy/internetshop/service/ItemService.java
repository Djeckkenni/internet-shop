package mate.acadamy.internetshop.service;

import mate.acadamy.internetshop.model.Product;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Product create(Product item);

    Product get(long id);

    Product update(Product item);

    boolean delete(long id);

    boolean delete(Product item);

    List<Product> getAll();
}
