package modern_kick_eshop.entities.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity (name = "order_item")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue
    private Long order_item_id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "order_id")
    private Order order;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn (name = "product_id")
    private Product product;

    @Column (name = "size")
    private String size;

    @Column (name = "quantity")
    private Integer quantity;

    @Column (name = "unit_price")
    private Double unitPrice;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderItem orderItem = (OrderItem) o;
        return order.equals(orderItem.order) &&
                product.equals(orderItem.product) &&
                quantity.equals(orderItem.quantity) &&
                size.equals(orderItem.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, quantity, product, size);
    }
}
