package modern_kick_eshop.services;

import modern_kick_eshop.entities.dao.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {

    List<Order> getOrdersByPeriod(LocalDateTime start, LocalDateTime end);
}
