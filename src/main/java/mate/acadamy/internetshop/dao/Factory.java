package mate.acadamy.internetshop.dao;

import mate.acadamy.internetshop.dao.impl.ItemDaoImpl;
import mate.acadamy.internetshop.service.ItemService;
import mate.acadamy.internetshop.service.impl.ItemServiceImpl;

public class Factory {
    private static ItemDao itemDao;
    private static ItemService itemService;

    public static ItemDao getItemDao() {
        if (itemDao == null) {
            itemDao = new ItemDaoImpl();
        }
        return itemDao;
    }

    public static ItemService getItemService() {
        if (itemService == null) {
            itemService = new ItemServiceImpl();
        }
        return itemService;
    }
}

