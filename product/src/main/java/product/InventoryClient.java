package product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "inventory-service")
public interface InventoryClient {
    @PostMapping("/inventory")
    public void addInventory(@RequestBody InventoryDTO inventoryDTO);

    @DeleteMapping("/inventory/{id}")
    public void deleteInventory(@PathVariable String id);
}