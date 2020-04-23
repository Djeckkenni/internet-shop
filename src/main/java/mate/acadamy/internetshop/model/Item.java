package mate.acadamy.internetshop.model;

import java.math.BigDecimal;

public class Item {
    private Long itemId;
    private String itemName;
    private BigDecimal itemPrice;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "Item{"
                + "itemId=" + itemId
                + ", itemName='" + itemName
                + '\'' + ", itemPrice="
                + itemPrice + '}';
    }
}

