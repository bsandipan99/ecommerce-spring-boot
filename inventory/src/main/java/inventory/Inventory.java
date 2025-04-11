package inventory;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Inventory {
    @Id
    private String productId;
    private int quantity;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}