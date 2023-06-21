package modern_kick_eshop.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import modern_kick_eshop.entities.dao.Order;
import modern_kick_eshop.services.OrderService;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping ("/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @GetMapping (produces = "application/json")
    public List<Order> getOrdersByPeriod(@RequestParam @DateTimeFormat (iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                         @RequestParam @DateTimeFormat (iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return orderService.getOrdersByPeriod(start, end);
    }
}
