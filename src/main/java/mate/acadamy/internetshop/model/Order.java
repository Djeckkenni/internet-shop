package mate.acadamy.internetshop.model;

import java.util.List;

public class Order {
    private Long orderId;
    private User user;
    private List<Product> items;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" +
                orderId + ", user="
                + user + ", items="
                + items + '}';
    }
}

