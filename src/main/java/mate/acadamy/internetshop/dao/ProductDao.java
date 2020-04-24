package mate.acadamy.internetshop.dao;

import java.util.List;
import java.util.Optional;
import mate.acadamy.internetshop.model.Product;

public interface ProductDao {
    Product create(Product product);

    Optional<Product> get(Long productId);

    Product update(Product product);

    boolean delete(Long productId);

    boolean delete(Product product);

    List<Product> getAll();
}

