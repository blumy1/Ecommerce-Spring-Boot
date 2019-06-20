package blumek.sb.ecommercespringboot.controllers;

import blumek.sb.ecommercespringboot.models.Order;
import blumek.sb.ecommercespringboot.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/orders")
    public Iterable<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping(value = "/order/{id}")
    public Order getOrders(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @PostMapping(value = "/orders")
    public Order saveUser(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @DeleteMapping(value = "/order/{id}")
    public void deleteUser(@PathVariable Integer id) {
        orderService.deleteOrder(id);
    }
}
