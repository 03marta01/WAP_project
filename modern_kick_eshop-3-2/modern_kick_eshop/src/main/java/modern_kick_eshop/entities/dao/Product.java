package modern_kick_eshop.entities.dao;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table (name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Data
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private Long product_id;

    @Column (name = "name")
    private String name;

    @Column (name = "description")
    private String description;

    @Column (name = "price")
    private Double price;

    @Column (name = "size")
    private String size;

    @Column (name = "color")
    private String color;

    @Column (name = "category")
    private String category;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return product_id.equals(product.product_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id);
    }
}

