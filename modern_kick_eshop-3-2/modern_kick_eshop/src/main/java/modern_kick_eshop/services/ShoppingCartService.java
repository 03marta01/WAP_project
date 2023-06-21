package modern_kick_eshop.services;

import modern_kick_eshop.entities.dao.Product;
import modern_kick_eshop.entities.dao.ShoppingCart;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ShoppingCartService {
    ShoppingCart addOrderItem(Product product, int qty);

    List<Long> getAllIds();
    List<ShoppingCart> getAllItemsInShoppingCart();
}
