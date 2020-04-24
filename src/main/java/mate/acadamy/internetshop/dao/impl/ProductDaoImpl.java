package mate.acadamy.internetshop.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import mate.acadamy.internetshop.dao.ProductDao;
import mate.acadamy.internetshop.dao.lib.Dao;
import mate.acadamy.internetshop.db.Storage;
import mate.acadamy.internetshop.model.Product;

@Dao
public class ProductDaoImpl implements ProductDao {
    @Override
    public Product create(Product product) {
        Storage.addProduct(product);
        return product;
    }

    @Override
    public Optional<Product> get(Long productId) {
        return Storage.products.stream()
                .filter(product -> product.getProductId()
                        .equals(productId)).findFirst();
    }

    @Override
    public Product update(Product product) {
        IntStream.range(0, Storage.products.size())
                .filter(index -> Storage.products.get(index).getProductId()
                        .equals(product.getProductId()))
                .forEach(index -> Storage.products.set(index, product));
        return product;
    }

    @Override
    public boolean delete(Long productId) {
        return Storage.products.removeIf(product -> product.getProductId().equals(productId));
    }

    @Override
    public boolean delete(Product product) {
        return Storage.products.remove(product);
    }

    @Override
    public List<Product> getAll() {
        return Storage.products;
    }
}



