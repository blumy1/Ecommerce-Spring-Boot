package blumek.sb.ecommercespringboot.controllers;

import blumek.sb.ecommercespringboot.models.Order;
import blumek.sb.ecommercespringboot.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Iterable<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping(value = "/{id}")
    public Order getOrder(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Order saveOrder(@RequestBody Order order) {
        order.setOrderedAt(new Date());
        return orderService.saveOrder(order);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
    }
}
