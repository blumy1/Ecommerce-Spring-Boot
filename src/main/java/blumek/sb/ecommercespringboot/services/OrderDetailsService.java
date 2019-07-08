package blumek.sb.ecommercespringboot.services;

import blumek.sb.ecommercespringboot.models.OrderDetail;

public interface OrderDetailsService {
    OrderDetail getOrderDetailById(Integer id);
    OrderDetail saveOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(Integer id);
    boolean exists(Integer id);
}
