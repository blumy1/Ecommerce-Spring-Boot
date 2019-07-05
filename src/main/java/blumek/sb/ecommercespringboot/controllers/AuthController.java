package blumek.sb.ecommercespringboot.controllers;

import blumek.sb.ecommercespringboot.models.User;
import blumek.sb.ecommercespringboot.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/login")
    public Integer login(@RequestBody User user) {
        return authService.login(user.getEmail(), user.getPassword());
    }
}
