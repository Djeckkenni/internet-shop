package mate.acadamy.internetshop.dao.impl;

import mate.acadamy.internetshop.dao.Dao;
import mate.acadamy.internetshop.dao.ItemDao;
import mate.acadamy.internetshop.dao.Storage;
import mate.acadamy.internetshop.model.Item;

import java.util.NoSuchElementException;

@Dao
public class ItemDaoImpl implements ItemDao {
    private static Long itemID = 0L;

    @Override
    public Item create(Item item) {
        item.setItemId(itemID);
        itemID++;
        Storage.items.add(item);
        return item;
    }

    @Override
    public Item get(Long itemID) {
        return Storage.items
                .stream()
                .filter(item -> item.getItemId().equals(itemID))
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("Can't find item with id " + itemID));
    }

    @Override
    public Item update(Item item) {
        for (Item i : Storage.items) {
            if (i.getItemId().equals(item.getItemId())) {
                int index = Storage.items.indexOf(i);
                i = Storage.items.set(index, item);
            }
        }
        return item;
    }

    @Override
    public void delete(Long itemId) {
        for (Item i : Storage.items) {
            if (i.getItemId().equals(itemId)) {
                int index = Storage.items.indexOf(i);
                Storage.items.remove(index);
                break;
            }
        }
    }

    @Override
    public void delete(Item item) {
        for (Item i : Storage.items) {
            if (i.equals(item)) {
                Storage.items.remove(i);
                break;
            }
        }
    }
}

