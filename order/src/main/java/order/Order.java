package order;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Order {
    @Id
    private String orderId;
    private String productId;
    private int orderQuantity;

    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }
}
