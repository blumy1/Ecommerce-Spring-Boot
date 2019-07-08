package blumek.sb.ecommercespringboot.controllers;

import blumek.sb.ecommercespringboot.exceptions.EmptyResourceException;
import blumek.sb.ecommercespringboot.models.User;
import blumek.sb.ecommercespringboot.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> login(@RequestBody User user) {
        if (user == null || user.getEmail() == null || user.getPassword() == null)
            throw new EmptyResourceException();

        Integer id = authService.login(user.getEmail(), user.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }
}
