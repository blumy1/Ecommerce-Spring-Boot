package blumek.sb.ecommercespringboot.controllers;

import blumek.sb.ecommercespringboot.exceptions.IdNotPositiveException;
import blumek.sb.ecommercespringboot.exceptions.OrderDetailEmptyException;
import blumek.sb.ecommercespringboot.exceptions.OrderDetailNotFoundException;
import blumek.sb.ecommercespringboot.exceptions.OrderDetailUnsaveableException;
import blumek.sb.ecommercespringboot.models.OrderDetail;
import blumek.sb.ecommercespringboot.services.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/orderDetails")
public class OrderDetailsController {
    private OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getOrderDetail(@PathVariable Integer id) {
        if (id <= 0)
            throw new IdNotPositiveException();

        OrderDetail orderDetail = orderDetailsService.getOrderDetailById(id);
        if (orderDetail == null)
            throw new OrderDetailNotFoundException(id);

        return ResponseEntity.status(HttpStatus.OK).body(orderDetail);
    }

    @PostMapping
    public ResponseEntity<Object> saveOrderDetail(@RequestBody OrderDetail orderDetail) {
        if (orderDetail == null)
            throw new OrderDetailEmptyException();

        if (orderDetail.getId() != null)
            orderDetail.setId(null);

        OrderDetail savedOrderDetail = orderDetailsService.saveOrderDetail(orderDetail);
        if (savedOrderDetail == null)
            throw new OrderDetailUnsaveableException();

        return ResponseEntity.status(HttpStatus.OK).body(savedOrderDetail);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateProducts(@RequestBody OrderDetail orderDetail, @PathVariable Integer id) {
        if (id <= 0)
            throw new IdNotPositiveException();

        if (!orderDetailsService.exists(id))
            throw new OrderDetailNotFoundException(id);

        orderDetail.setId(id);
        OrderDetail savedOrderDetail = orderDetailsService.saveOrderDetail(orderDetail);
        if (savedOrderDetail == null)
            throw new OrderDetailUnsaveableException();

        return ResponseEntity.status(HttpStatus.OK).body(savedOrderDetail);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOrderDetail(@PathVariable Integer id) {
        if (id <= 0)
            throw new IdNotPositiveException();

        orderDetailsService.deleteOrderDetail(id);
    }
}
