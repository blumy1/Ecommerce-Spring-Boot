package blumek.sb.ecommercespringboot.controllers;

import blumek.sb.ecommercespringboot.exceptions.IdNotPositiveException;
import blumek.sb.ecommercespringboot.exceptions.OrderEmptyException;
import blumek.sb.ecommercespringboot.exceptions.OrderNotFoundException;
import blumek.sb.ecommercespringboot.exceptions.OrderUnsaveableException;
import blumek.sb.ecommercespringboot.models.Order;
import blumek.sb.ecommercespringboot.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<Object> getOrders() {
        Iterable<Order> orders = orderService.getAllOrders();
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getOrder(@PathVariable Integer id) {
        if (id <= 0)
            throw new IdNotPositiveException();

        Order order = orderService.getOrderById(id);
        if (order == null)
            throw new OrderNotFoundException(id);

        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @PostMapping
    public ResponseEntity<Object> saveOrder(@RequestBody Order order) {
        if (order == null)
            throw new OrderEmptyException();

        if (order.getId() != null)
            order.setId(null);

        order.setOrderedAt(new Date());

        Order savedOrder = orderService.saveOrder(order);
        if (savedOrder == null)
            throw new OrderUnsaveableException();

        return ResponseEntity.status(HttpStatus.OK).body(savedOrder);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateProducts(@RequestBody Order order, @PathVariable Integer id) {
        if (id <= 0)
            throw new IdNotPositiveException();

        if (!orderService.exists(id))
            throw new OrderNotFoundException(id);

        order.setId(id);
        Order savedOrder = orderService.saveOrder(order);
        if (savedOrder == null)
            throw new OrderUnsaveableException();

        return ResponseEntity.status(HttpStatus.OK).body(savedOrder);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        if (id <= 0)
            throw new IdNotPositiveException();

        orderService.deleteOrder(id);
    }
}
