package mate.acadamy.internetshop.dao.impl;
import mate.acadamy.internetshop.dao.BucketDao;
import mate.acadamy.internetshop.dao.Storage;
import mate.acadamy.internetshop.model.Bucket;

import java.util.NoSuchElementException;

public class BucketDaoImpl implements BucketDao {

    @Override
    public Bucket get(long bucketId) {
        return Storage.buckets
                .stream()
                .filter(bucket -> bucket.getBucketId().equals(bucketId))
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("Can't find bucket with id " + bucketId));
    }

    @Override
    public Bucket update(Bucket bucket) {
        return null;
    }
}

