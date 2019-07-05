package blumek.sb.ecommercespringboot.controllers;

import blumek.sb.ecommercespringboot.models.OrderDetail;
import blumek.sb.ecommercespringboot.services.OrderDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orderDetails")
public class OrderDetailsController {
    private OrderDetailsService orderDetailsService;

    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping(value = "/{id}")
    public OrderDetail getOrderDetail(@PathVariable Integer id) {
        return orderDetailsService.getOrderDetailById(id);
    }

    @PostMapping
    public OrderDetail saveOrderDetail(@RequestBody OrderDetail orderDetail) {
        return orderDetailsService.saveOrderDetail(orderDetail);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOrderDetail(@PathVariable Integer id) {
        orderDetailsService.deleteOrderDetail(id);
    }
}
