package mate.acadamy.internetshop.service;

import mate.acadamy.internetshop.model.Bucket;

public interface BucketService {
    Bucket addItem(long bucketId, long itemId);
}
