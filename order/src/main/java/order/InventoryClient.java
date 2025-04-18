package order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "inventory-service")
public interface InventoryClient {
    @GetMapping("/inventory/{productId}")
    public InventoryDTO getInventoryByProductId(@PathVariable String productId);

    @PostMapping("/inventory")
    public void addInventory(InventoryDTO inventory);

    @PutMapping("/inventory/{id}")
    public void updateInventory(@PathVariable String id, int quantity);
}