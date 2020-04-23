package mate.acadamy.internetshop.service.impl;

import mate.acadamy.internetshop.dao.Inject;
import mate.acadamy.internetshop.dao.ProductDao;
import mate.acadamy.internetshop.dao.Service;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.service.ItemService;

import java.util.List;
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
    public Product get(long id) {
        return itemDao.get(id).get();
    }

    @Override
    public Product update(Product item) {
        return itemDao.update(item);
    }

    @Override
    public boolean delete(long id) {
        return itemDao.delete(id);
    }

    @Override
    public boolean delete(Product item) {
        return itemDao.delete(item);
    }

    @Override
    public List<Product> getAll() {
        return itemDao.getAll();
    }
}

