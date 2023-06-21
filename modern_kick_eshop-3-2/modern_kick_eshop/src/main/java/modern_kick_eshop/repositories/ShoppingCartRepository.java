package modern_kick_eshop.repositories;

import modern_kick_eshop.entities.dao.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE shopping_cart", nativeQuery = true)
    void truncateTable();
}
