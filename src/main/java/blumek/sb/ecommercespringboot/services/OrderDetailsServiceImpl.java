package blumek.sb.ecommercespringboot.services;

import blumek.sb.ecommercespringboot.models.OrderDetail;
import blumek.sb.ecommercespringboot.repositories.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public OrderDetail getOrderDetailById(Integer id) {
        Optional<OrderDetail> optionalOrderDetail = orderDetailsRepository.findById(id);
        return optionalOrderDetail.orElse(null);
    }

    @Override
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailsRepository.save(orderDetail);
    }

    @Override
    public boolean exists(Integer id) {
        return orderDetailsRepository.existsById(id);
    }

    @Override
    public void deleteOrderDetail(Integer id) {
        orderDetailsRepository.deleteById(id);
    }
}
