package product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private String id;
    private String description;
    private double price;    
    
}
