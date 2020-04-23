package mate.acadamy.internetshop.dao;

import mate.acadamy.internetshop.model.Bucket;

public interface BucketDao {
    Bucket create(Bucket bucket);

    Bucket get(long bucketId);

    Bucket update(Bucket bucket);
}

