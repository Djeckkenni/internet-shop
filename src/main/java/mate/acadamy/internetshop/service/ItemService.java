package mate.acadamy.internetshop.service;

import mate.acadamy.internetshop.model.Item;

public interface ItemService {
    Item create(Item item);

    Item get(long id);

    Item update(Item item);

    void delete(long id);

    void delete(Item item);
}
