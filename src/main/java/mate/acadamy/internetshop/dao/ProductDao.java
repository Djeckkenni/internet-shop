package mate.acadamy.internetshop.dao;

import mate.acadamy.internetshop.model.Product;

import java.util.Optional;

public interface ProductDao {
    Product create(Product product);

    Optional<Product> get(Long id);

    Product update(Product product);

    void delete(Long productId);

    void delete(Product product);
}

