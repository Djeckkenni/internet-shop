package mate.acadamy.internetshop.service.impl;

import mate.acadamy.internetshop.dao.BucketDao;
import mate.acadamy.internetshop.dao.ItemDao;
import mate.acadamy.internetshop.model.Bucket;
import mate.acadamy.internetshop.model.Item;
import mate.acadamy.internetshop.service.BucketService;

public class BucketServiceImpl implements BucketService {
    private BucketDao bucketDao;
    private ItemDao itemDao;

    @Override
    public Bucket addItem(long bucketId, long itemId) {
        Bucket bucket = bucketDao.get(bucketId);
        Item item = itemDao.get(itemId);
        bucket.getItems().add(item);
        return bucketDao.update(bucket);
    }
}

