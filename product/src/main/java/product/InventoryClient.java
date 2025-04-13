package product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "inventory-service")
public interface InventoryClient {
    @PostMapping("/inventory")
    public void addInventory(@RequestBody Inventory inventory);
}