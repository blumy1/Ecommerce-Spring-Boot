package blumek.sb.ecommercespringboot.bootstrap;

import blumek.sb.ecommercespringboot.models.Price;
import blumek.sb.ecommercespringboot.models.Product;
import blumek.sb.ecommercespringboot.models.Quantity;
import blumek.sb.ecommercespringboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Logger;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final ProductRepository productRepository;
    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    public ProductLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Product shirt = new Product();
        shirt.setCreatedAt(new Date());
        shirt.setName("Spring T-Shirt");
        Price shirtPrice = new Price();
        shirtPrice.setAmount(BigDecimal.valueOf(99.90));
        shirtPrice.setCurrency("zł");
        shirt.setPrice(shirtPrice);
        Quantity shirtQuantity = new Quantity();
        shirtQuantity.setQuantity(1);
        shirtQuantity.setMeasure("piece");
        shirt.setQuantity(shirtQuantity);
        productRepository.save(shirt);
        logger.info("SAVED PRODUCT - id: " + shirt.getId());
        Product mug = new Product();
        mug.setCreatedAt(new Date());
        mug.setName("Spring Mug");
        Price mugPrice = new Price();
        mugPrice.setAmount(BigDecimal.valueOf(29.90));
        mugPrice.setCurrency("zł");
        mug.setPrice(mugPrice);
        Quantity mugQuantity = new Quantity();
        mugQuantity.setQuantity(1);
        mugQuantity.setMeasure("piece");
        mug.setQuantity(mugQuantity);
        productRepository.save(mug);
        logger.info("SAVED PRODUCT - id:" + mug.getId());
    }
}