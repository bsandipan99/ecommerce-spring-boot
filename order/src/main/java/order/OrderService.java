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
        ProductDTO productDTO = productClient.getProductById(order.getProductId());
        InventoryDTO inventoryDTO = inventoryClient.getInventoryByProductId( productDTO.getId() );

        if(inventoryDTO.getQuantity() < order.getQuantity()) {
            throw new RuntimeException("Product not present in enough quantity!!!");    
        } else {
            orderRepository.save(order);

            int updatedQuantity = inventoryDTO.getQuantity() - order.getQuantity();
            inventoryClient.updateInventory( productDTO.getId(), updatedQuantity );
        }
    }
}
