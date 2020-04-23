package mate.acadamy.internetshop.service;

import mate.acadamy.internetshop.model.Product;

import java.util.Optional;

public interface ItemService {
    Product create(Product item);

    Optional<Product> get(long id);

    Product update(Product item);

    void delete(long id);

    void delete(Product item);
}
