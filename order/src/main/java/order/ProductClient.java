package order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import order.Product;

@FeignClient(name = "product-service")
public interface ProductClient {
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable String id);
}
