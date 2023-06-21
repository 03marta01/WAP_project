package modern_kick_eshop.entities.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity (name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer implements Serializable {

    //@Id
    //@GeneratedValue
    //private Long customer_id;

    @Id
    @Column (name = "email")
    private String email;

    @Column (name = "first_name")
    private String first_name;

    @Column (name = "last_name")
    private String last_name;



    @Column (name = "street")
    private String street;

    @Column (name = "street_number")
    private String street_number;

    @Column (name = "city")
    private String city;

    @Column (name = "postal_code")
    private String postal_code;

    @Column (name = "country")
    private String country;

    @Column (name = "phone_number")
    private String phone_number;

    @JsonIgnore
    @Column (name = "password")
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
