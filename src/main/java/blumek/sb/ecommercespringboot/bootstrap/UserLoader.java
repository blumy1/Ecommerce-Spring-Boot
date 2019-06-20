package blumek.sb.ecommercespringboot.bootstrap;

import blumek.sb.ecommercespringboot.models.*;
import blumek.sb.ecommercespringboot.repositories.OrderRepository;
import blumek.sb.ecommercespringboot.repositories.ProductRepository;
import blumek.sb.ecommercespringboot.repositories.UserRepository;
import blumek.sb.ecommercespringboot.services.ProductService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Logger;

@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    public UserLoader(UserRepository userRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        User user1 = new User();
        user1.setCreatedAt(new Date());
        user1.setLogin("Syzak");
        user1.setPassword("Haslo123");
        user1.setEmail("Syzak@Gmail.com");
        user1.setFirstName("Szymon");
        user1.setLastName("Blum");
        Address user1Address1 = new Address();
        user1Address1.setCountry("Poland");
        user1Address1.setCity("Konin");
        user1Address1.setZipCode("62-510");
        user1Address1.setStreet("11 Listopada 16");
        user1Address1.setHouse("61");
        Address user1Address2 = new Address();
        user1Address2.setCountry("Poland");
        user1Address2.setCity("Poznań");
        user1Address2.setZipCode("65-450");
        user1Address2.setStreet("Os. Sobieskiego 1");
        user1Address2.setHouse("12");
        user1Address1.setUser(user1);
        user1Address2.setUser(user1);
        user1.getAddresses().add(user1Address1);
        user1.getAddresses().add(user1Address2);
        userRepository.save(user1);
        logger.info("SAVED USER (" + user1.getLogin() + ")");
        User user2 = new User();
        user2.setCreatedAt(new Date());
        user2.setLogin("Koza");
        user2.setPassword("Koza123");
        user2.setEmail("Koza@Gmail.com");
        user2.setFirstName("Piotr");
        user2.setLastName("Nowak");
        Address user2Address1 = new Address();
        user2Address1.setCountry("Poland");
        user2Address1.setCity("Wroclaw");
        user2Address1.setZipCode("22-550");
        user2Address1.setStreet("Słoneczna 12");
        user2Address1.setHouse("6");
        user2Address1.setUser(user2);
        user2.getAddresses().add(user2Address1);
        logger.info("SAVED USER (" + user2.getLogin() + ")");
        userRepository.save(user2);

        Order order = new Order();
        order.setOrderedAt(new Date());
        order.setUser(user1);
        OrderDetails orderDetails1 = new OrderDetails();

        Product legs = new Product();
        legs.setCreatedAt(new Date());
        legs.setName("Spring Legs");
        Price legsPrice = new Price();
        legsPrice.setAmount(BigDecimal.valueOf(49.90));
        legsPrice.setCurrency("zł");
        legs.setPrice(legsPrice);
        Quantity legsQuantity = new Quantity();
        legsQuantity.setQuantity(1);
        legsQuantity.setMeasure("piece");
        legs.setQuantity(legsQuantity);
        productRepository.save(legs);
        logger.info("SAVED PRODUCT " + legs.getId());

        orderDetails1.setProduct(legs);
        orderDetails1.setQuantity(legs.getQuantity());
        orderDetails1.setPrice(legs.getPrice());
        orderDetails1.setOrder(order);

        order.getOrderDetails().add(orderDetails1);
        orderRepository.save(order);
        logger.info("SAVED ORDER " + order.getId());
    }
}
