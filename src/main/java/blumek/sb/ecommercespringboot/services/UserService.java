package blumek.sb.ecommercespringboot.services;

import blumek.sb.ecommercespringboot.models.User;

public interface UserService {
    Iterable<User> getAllUsers();
    User getUserById(Integer id);
    User saveUser(User product);
    void deleteUser(Integer id);
    boolean exists(Integer id);
}
