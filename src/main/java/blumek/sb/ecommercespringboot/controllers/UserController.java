package blumek.sb.ecommercespringboot.controllers;

import blumek.sb.ecommercespringboot.exceptions.IdNotPositiveException;
import blumek.sb.ecommercespringboot.exceptions.UserEmptyException;
import blumek.sb.ecommercespringboot.exceptions.UserNotFoundException;
import blumek.sb.ecommercespringboot.exceptions.UserUnsaveableException;
import blumek.sb.ecommercespringboot.models.User;
import blumek.sb.ecommercespringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> getUsers() {
        Iterable<User> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Integer id) {
        if (id <= 0)
            throw new IdNotPositiveException();

        User user = userService.getUserById(id);
        if (user == null)
            throw new UserNotFoundException(id);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        if (user == null)
            throw new UserEmptyException();

        if (user.getId() != null)
            user.setId(null);

        user.setCreatedAt(new Date());

        User savedUser = userService.saveUser(user);
        if (savedUser == null)
            throw new UserUnsaveableException();

        return ResponseEntity.status(HttpStatus.OK).body(savedUser);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable Integer id) {
        if (id <= 0)
            throw new IdNotPositiveException();

        if (!userService.exists(id))
            throw new UserNotFoundException(id);

        user.setId(id);
        User savedUser = userService.saveUser(user);
        if (savedUser == null)
            throw new UserUnsaveableException();

        return ResponseEntity.status(HttpStatus.OK).body(savedUser);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Integer id) {
        if (id <= 0)
            throw new IdNotPositiveException();

        userService.deleteUser(id);
    }
}
