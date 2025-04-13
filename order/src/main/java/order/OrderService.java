package order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ProductClient productClient;

    @Autowired
    private InventoryClient inventoryClient; 

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderEntity getOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void addOrder(OrderEntity order) {
        Product product = productClient.getProductById(order.getProductId());
        Inventory inventory = inventoryClient.getInventoryByProductId( product.getId() );

        if(inventory.getQuantity() < order.getQuantity()) {
            throw new RuntimeException("Product not present in enough quantity!!!");    
        } else {
            orderRepository.save(order);
            inventory.setQuantity(inventory.getQuantity() - order.getQuantity());
            inventoryClient.addInventory( inventory );
        }
    }
}
