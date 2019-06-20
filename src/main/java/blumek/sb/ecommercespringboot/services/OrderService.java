package blumek.sb.ecommercespringboot.services;

import blumek.sb.ecommercespringboot.models.Order;

public interface OrderService {
    Iterable<Order> getAllOrders();
    Order getOrderById(Integer id);
    Order saveOrder(Order order);
    void deleteOrder(Integer id);
}
