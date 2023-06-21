package modern_kick_eshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import modern_kick_eshop.entities.dao.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
