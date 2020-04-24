package mate.acadamy.internetshop.model;

import java.util.List;

public class ShoppingCart {
    private Long shoppingCartId;
    private List<Product> products;
    private User user;

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
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
        return "ShoppingCart{" + "shoppingCartId="
                + shoppingCartId + ", products="
                + products + ", user="
                + user + '}';
    }
}

