package blumek.sb.ecommercespringboot.controllers;

import blumek.sb.ecommercespringboot.models.User;
import blumek.sb.ecommercespringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public Iterable<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping(value = "/users")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping(value = "/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
