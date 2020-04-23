package mate.acadamy.internetshop.service.impl;

import mate.acadamy.internetshop.dao.Inject;
import mate.acadamy.internetshop.dao.ItemDao;
import mate.acadamy.internetshop.dao.Service;
import mate.acadamy.internetshop.model.Item;
import mate.acadamy.internetshop.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
    @Inject
    private ItemDao itemDao;

    @Override
    public Item create(Item item) {
        return itemDao.create(item);
    }

    @Override
    public Item get(long id) {
        return itemDao.get(id);
    }

    @Override
    public Item update(Item item) {
        return itemDao.update(item);
    }

    @Override
    public void delete(long id) {
        itemDao.delete(id);
    }

    @Override
    public void delete(Item item) {
        itemDao.delete(item);
    }
}

