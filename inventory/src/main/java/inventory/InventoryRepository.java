package inventory;

import org.springframework.data.jpa.repository.JpaRepository;
 
public interface InventoryRepository extends JpaRepository<Inventory,String>{
    
}
