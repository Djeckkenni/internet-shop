package mate.acadamy.internetshop.model;

import java.math.BigDecimal;

public class Product {
    private Long productId;
    private String productName;
    private BigDecimal productPrice;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId
                + ", productName='" + productName
                + '\'' + ", productPrice="
                + productPrice + '}';
    }
}

