package mate.acadamy.internetshop.service.impl;

import mate.acadamy.internetshop.dao.Inject;
import mate.acadamy.internetshop.dao.ProductDao;
import mate.acadamy.internetshop.dao.Service;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.service.ItemService;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    @Inject
    private ProductDao itemDao;

    @Override
    public Product create(Product item) {
        return itemDao.create(item);
    }

    @Override
    public Optional<Product> get(long id) {
        return itemDao.get(id);
    }

    @Override
    public Product update(Product item) {
        return itemDao.update(item);
    }

    @Override
    public void delete(long id) {
        itemDao.delete(id);
    }

    @Override
    public void delete(Product item) {
        itemDao.delete(item);
    }
}

