package mate.acadamy.internetshop.service.impl;

import mate.acadamy.internetshop.dao.ProductDao;
import mate.acadamy.internetshop.inject.lib.Inject;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.service.ProductService;
import mate.acadamy.internetshop.service.lib.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Inject
    private ProductDao productDao;

    @Override
    public Product create(Product product) {
        return productDao.create(product);
    }

    @Override
    public Product get(Long productId) {
        return productDao.get(productId).get();
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Product update(Product product) {
        return productDao.update(product);
    }

    @Override
    public boolean delete(Long productId) {
        return productDao.delete(productId);
    }
}

