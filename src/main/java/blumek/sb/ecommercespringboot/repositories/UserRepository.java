package blumek.sb.ecommercespringboot.repositories;

import blumek.sb.ecommercespringboot.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
