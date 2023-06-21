package modern_kick_eshop.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import modern_kick_eshop.entities.dao.Product;
import modern_kick_eshop.entities.dao.ShoppingCart;
import modern_kick_eshop.repositories.ShoppingCartRepository;
import modern_kick_eshop.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository repository;

    @Override
    public ShoppingCart addOrderItem(Product product, int qty) {
        List<ShoppingCart> items = repository.findAll();
        for (ShoppingCart item : items) {
            if (item.getProduct_id().equals(product.getProduct_id())) {
                qty += item.getQuantity();
                repository.delete(item);
            }
            }
        return repository.save(ShoppingCart.builder()
                .product_id(product.getProduct_id())
                .quantity(qty)
                .build());
    }

    @Override
    public List<ShoppingCart> getAllItemsInShoppingCart() {
        return repository.findAll();
    }


    @Override
    public List<Long> getAllIds() {
        List<ShoppingCart> items = repository.findAll();
        List<Long> itemsId = new ArrayList<>();
        for (ShoppingCart item : items) {
            itemsId.add(item.getProduct_id());
        }
        return itemsId;
    }
}

