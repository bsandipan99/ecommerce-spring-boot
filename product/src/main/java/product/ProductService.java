package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private InventoryClient inventoryClient;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
        Inventory inventory = new Inventory();
        inventory.setProductId( product.getId() );
        inventory.setQuantity( 10 );

        System.out.println(inventory.getProductId() + " --> " + inventory.getQuantity());

        inventoryClient.addInventory(inventory);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }
}
