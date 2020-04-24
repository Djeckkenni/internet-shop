package mate.acadamy.internetshop.model;

import java.util.List;

public class Bucket {
    private Long bucketId;
    private List<Product> products;
    private User user;

    public Long getBucketId() {
        return bucketId;
    }

    public void setBucketId(Long bucketId) {
        this.bucketId = bucketId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bucket{" + "bucketId="
                + bucketId + ", products="
                + products + ", user="
                + user + '}';
    }
}


