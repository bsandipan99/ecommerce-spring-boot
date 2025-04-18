package order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class InventoryDTO {
    @Id
    private String productId;
    private int quantity;
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
