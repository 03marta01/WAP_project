package modern_kick_eshop.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import modern_kick_eshop.entities.dao.ShoppingCart;
import modern_kick_eshop.entities.dto.OrderDto;
import modern_kick_eshop.exceptions.NoItemsInOrderException;
import modern_kick_eshop.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import modern_kick_eshop.entities.dao.Order;
import modern_kick_eshop.services.OrderService;
import java.time.LocalDateTime;
import java.util.List;
import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public void createOrder(List<ShoppingCart> shoppingCartItems){

    }

    private void checkIfItemsAreEmpty(OrderDto order) {
        if (isNull(order) || order.getItems().isEmpty()) {
            throw new NoItemsInOrderException("Order creation request doesn't contain any Products");
        }
    }

    @Override
    public List<Order> getOrdersByPeriod(LocalDateTime start, LocalDateTime end) {
        log.info("### Fetching orders from the database");
        return orderRepository.findByCreatedAtBetween(start, end);
    }
}
