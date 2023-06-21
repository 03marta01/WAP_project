package modern_kick_eshop.entities.dto;

import modern_kick_eshop.entities.dao.Customer;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.List;
@Value
@Builder
public class OrderDto {

    @NotNull
    List<OrderItemDto> items;

    @NotNull
    private Customer customer;

    @NotNull
    private Double totalPrice;
}
