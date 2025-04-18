package order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductDTO {
    @Id
    private String id;
    private String title;
    private double price;
    
    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
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

}
