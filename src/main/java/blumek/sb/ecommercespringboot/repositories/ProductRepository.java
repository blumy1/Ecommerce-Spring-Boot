package blumek.sb.ecommercespringboot.repositories;

import blumek.sb.ecommercespringboot.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
