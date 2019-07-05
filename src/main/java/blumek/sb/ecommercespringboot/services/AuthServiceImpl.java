package blumek.sb.ecommercespringboot.services;

import blumek.sb.ecommercespringboot.models.User;
import blumek.sb.ecommercespringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Integer login(String email, String password) {
        User user = userRepository.getUserByEmailAndPassword(email, password);
        if (user == null) return 0;
        return user.getId();
    }
}
