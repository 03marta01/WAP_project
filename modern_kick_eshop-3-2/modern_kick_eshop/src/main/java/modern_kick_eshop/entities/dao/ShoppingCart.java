package modern_kick_eshop.entities.dao;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "shopping_cart")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ShoppingCart implements Serializable {

    @Id
    @GeneratedValue
    private Long shoppingCart_id;

    @Column(name="product_id")
    private Long product_id;

    @Column(name="quantity")
    private int quantity;

}
