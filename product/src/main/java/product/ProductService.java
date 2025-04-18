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

    public void addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setId( productRequest.getId() );
        product.setTitle( productRequest.getTitle() );
        product.setPrice( productRequest.getPrice() );
        productRepository.save(product);

        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setProductId( productRequest.getId() );
        inventoryDTO.setQuantity(productRequest.getQuantity() );
        inventoryClient.addInventory(inventoryDTO);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }
}
