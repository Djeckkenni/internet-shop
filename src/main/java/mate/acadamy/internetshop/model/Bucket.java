package mate.acadamy.internetshop.model;

import java.util.List;
import java.util.Optional;

public class Bucket {
    private Long bucketId;
    private List<Optional<Product>> items;
    private User user;

    public Long getBucketId() {
        return bucketId;
    }

    public void setBucketId(Long bucketId) {
        this.bucketId = bucketId;
    }

    public List<Optional<Product>> getItems() {
        return items;
    }

    public void setItems(List<Optional<Product>> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "bucketId=" + bucketId +
                ", items=" + items +
                ", user=" + user +
                '}';
    }
}


