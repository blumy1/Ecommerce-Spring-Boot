package blumek.sb.ecommercespringboot.repositories;

import blumek.sb.ecommercespringboot.models.OrderDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetail, Integer> {
}
