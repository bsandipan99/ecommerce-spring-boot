package order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "inventory-service")
public interface InventoryClient {
    @GetMapping("/inventory/{productId}")
    public Inventory getInventoryByProductId(@PathVariable String productId);

    @PostMapping("/inventory")
    public void addInventory(Inventory inventory);
}