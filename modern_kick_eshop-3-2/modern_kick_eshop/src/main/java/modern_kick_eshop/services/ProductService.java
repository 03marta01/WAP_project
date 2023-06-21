package modern_kick_eshop.services;

import modern_kick_eshop.entities.dao.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product getProductById(long productId);

    List<Product> getProductsByCategory(String category);
}
