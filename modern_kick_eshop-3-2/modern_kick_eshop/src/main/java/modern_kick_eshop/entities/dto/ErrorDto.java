package modern_kick_eshop.entities.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorDto {
    private String message;
}
