package product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductRequest {
    @Id
    private String id;
    private String title;
    private double price;
    private int quantity;
    
    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

}
