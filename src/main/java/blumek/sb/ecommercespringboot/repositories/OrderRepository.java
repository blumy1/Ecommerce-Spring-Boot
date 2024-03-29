package blumek.sb.ecommercespringboot.repositories;

import blumek.sb.ecommercespringboot.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
    boolean existsById(Integer id);
}
