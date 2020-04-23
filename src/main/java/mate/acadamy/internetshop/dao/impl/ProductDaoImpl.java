package mate.acadamy.internetshop.dao.impl;

import mate.acadamy.internetshop.dao.Dao;
import mate.acadamy.internetshop.dao.ProductDao;
import mate.acadamy.internetshop.dao.Storage;
import mate.acadamy.internetshop.model.Product;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Dao
public class ProductDaoImpl implements ProductDao {

    @Override
    public Product create(Product product) {
        Storage.addItem(product);
        return product;
    }

    @Override
    public Optional<Product> get(Long id) {
        return Storage.items.stream()
                .filter(product -> product.getItemId()
                        .equals(id)).findFirst();
    }

    @Override
    public Product update(Product product) {
        IntStream.range(0, Storage.items.size())
                .filter(idx -> Storage.items.get(idx).getItemId().equals(product.getItemId()))
                .forEach(idx -> Storage.items.set(idx, product));
        return product;
    }

    @Override
    public void delete(Long productId) {
        Storage.items.removeIf(item -> item.getItemId().equals(productId));
    }

    @Override
    public void delete(Product product) {
        Storage.items.remove(product);
    }

    @Override
    public List<Product> getAll() {
        return Storage.items;
    }
}



