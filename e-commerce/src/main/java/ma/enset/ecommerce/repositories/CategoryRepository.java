package ma.enset.ecommerce.repositories;

import ma.enset.ecommerce.entities.Category;
import ma.enset.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
