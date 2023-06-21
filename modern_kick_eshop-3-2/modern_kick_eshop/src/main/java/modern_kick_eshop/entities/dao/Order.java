package modern_kick_eshop.entities.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity (name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private Long order_id;

    @OneToMany (mappedBy = "order", fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<OrderItem> items;

    @CreationTimestamp
    @Column (name = "created_at")
    private LocalDateTime createdAt;

    @Column (name = "total_price")
    private Double totalPrice;

    @Column (name = "status")
    private String status;

    @Column (name = "payment_method")
    private String paymentMethod;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return order_id.equals(order.order_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id);
    }

    public Double getTotalPrice() {
        return items.stream().mapToDouble(item -> item.getUnitPrice() * item.getQuantity()).sum();
    }
}