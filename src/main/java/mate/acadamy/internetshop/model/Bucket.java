package mate.acadamy.internetshop.model;

import java.util.List;

public class Bucket {
    private Long bucketId;
    private List<Item> items;
    private Long orderId;

    public Long getBucketId() {
        return bucketId;
    }

    public void setBucketId(Long bucketId) {
        this.bucketId = bucketId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Bucket{" + "bucketId="
                + bucketId + ", items="
                + items + ", orderId="
                + orderId + '}';
    }
}

