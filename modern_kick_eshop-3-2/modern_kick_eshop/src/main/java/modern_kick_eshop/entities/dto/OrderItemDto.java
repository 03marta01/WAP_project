package modern_kick_eshop.entities.dto;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Builder
public class OrderItemDto {

    @NotNull
    private Long productId;

    @NotNull
    private Long orderItemId;

    @NotNull
    private Integer quantity;
}
