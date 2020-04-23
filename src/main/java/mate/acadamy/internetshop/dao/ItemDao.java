package mate.acadamy.internetshop.dao;

import mate.acadamy.internetshop.model.Item;

public interface ItemDao {
    Item create(Item item);

    Item get(Long itemId);

    Item update(Item item);

    void delete(Long itemId);

    void delete(Item item);
}

