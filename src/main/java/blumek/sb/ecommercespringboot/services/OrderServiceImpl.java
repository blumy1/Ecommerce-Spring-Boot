package blumek.sb.ecommercespringboot.services;

import blumek.sb.ecommercespringboot.models.Order;
import blumek.sb.ecommercespringboot.models.Product;
import blumek.sb.ecommercespringboot.repositories.OrderRepository;
import blumek.sb.ecommercespringboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElseGet(Order::new);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
