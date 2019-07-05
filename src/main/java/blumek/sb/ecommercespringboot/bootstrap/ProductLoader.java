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
        String name = "Belstaff resolve waterproof leather boots - brown";
        String description = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique" +
                " necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia," +
                " necessitatibus quae sint natus. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim " +
                " aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.";
        String imgUrl = "https://www.urbanrider.co.uk/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/r/e/resolve_brown_anglepair.jpg";
        Price price = new Price(BigDecimal.valueOf(276.60), "usd");
        Quantity quantity = new Quantity(1, "item");
        Product product1 = new Product(name, description, imgUrl, price, quantity, new Date());
        productRepository.save(product1);
        logger.info("SAVED PRODUCT - id: " + product1.getId());


        name = "Belstaff Anderson boots - oak brown";
        imgUrl = "https://www.urbanrider.co.uk/media/catalog/product/cache/1/image/85e4522595efc69f496374d01ef2bf13/4/7/47800005_anderson-short-boots-man_60082.jpg";
        price = new Price(BigDecimal.valueOf(325.00), "usd");
        Product product2 = new Product(name, description, imgUrl, price, quantity, new Date());
        productRepository.save(product2);
        logger.info("SAVED PRODUCT - id: " + product2.getId());


        name = "Belstaff duration waterproof leather boots - black";
        imgUrl = "https://www.urbanrider.co.uk/media/catalog/product/cache/1/image/85e4522595efc69f496374d01ef2bf13/d/u/duration_black_anglepair.jpg";
        price = new Price(BigDecimal.valueOf(237.68), "usd");
        Product product3 = new Product(name, description, imgUrl, price, quantity, new Date());
        productRepository.save(product3);
        logger.info("SAVED PRODUCT - id: " + product3.getId());

        name = "Merlin G24 stockwell crazyhorse leather boots - brown";
        imgUrl = "https://www.urbanrider.co.uk/media/catalog/product/cache/1/image/85e4522595efc69f496374d01ef2bf13/_/d/_dsc7282_1.jpg";
        price = new Price(BigDecimal.valueOf(129.98), "usd");
        Product product4 = new Product(name, description, imgUrl, price, quantity, new Date());
        productRepository.save(product4);
        logger.info("SAVED PRODUCT - id: " + product4.getId());

        name = "Merlin G24 stockwell crazyhorse leather boots - black";
        imgUrl = "https://www.urbanrider.co.uk/media/catalog/product/cache/1/image/85e4522595efc69f496374d01ef2bf13/_/d/_dsc7282_2_.jpg";
        Product product5 = new Product(name, description, imgUrl, price, quantity, new Date());
        productRepository.save(product5);
        logger.info("SAVED PRODUCT - id: " + product5.getId());

        name = "Revit mohawk 2 boots - black";
        imgUrl = "https://www.urbanrider.co.uk/media/catalog/product/cache/1/image/85e4522595efc69f496374d01ef2bf13/f/b/fbr043_1010mf_300rgb08.jpg";
        price = new Price(BigDecimal.valueOf(161.99), "usd");
        quantity = new Quantity(1, "item");
        Product product6 = new Product(name, description, imgUrl, price, quantity, new Date());
        productRepository.save(product6);
        logger.info("SAVED PRODUCT - id: " + product6.getId());

        name = "Revit yukon boots - sand";
        imgUrl = "https://www.urbanrider.co.uk/media/catalog/product/cache/1/image/85e4522595efc69f496374d01ef2bf13/f/b/fbr044_7660mf_300rgb08.jpg";
        price = new Price(BigDecimal.valueOf(152.99), "usd");
        Product product7 = new Product(name, description, imgUrl, price, quantity, new Date());
        productRepository.save(product7);
        logger.info("SAVED PRODUCT - id: " + product7.getId());

        name = "Merlin G24 drax boots - olive";
        imgUrl = "https://www.urbanrider.co.uk/media/catalog/product/cache/1/image/85e4522595efc69f496374d01ef2bf13/d/r/drax-brown.jpg";
        price = new Price(BigDecimal.valueOf(149.99), "usd");
        Product product8 = new Product(name, description, imgUrl, price, quantity, new Date());
        productRepository.save(product8);
        logger.info("SAVED PRODUCT - id: " + product8.getId());

        name = "BSMC X rokker urban racer boots - mahogany";
        imgUrl = "https://www.urbanrider.co.uk/media/catalog/product/cache/1/image/85e4522595efc69f496374d01ef2bf13/r/o/rokker_boot_main_-_72.jpg";
        price = new Price(BigDecimal.valueOf(329.00), "usd");
        Product product9 = new Product(name, description, imgUrl, price, quantity, new Date());
        productRepository.save(product9);
        logger.info("SAVED PRODUCT - id: " + product9.getId());

        name = "Revit ginza 2 boots - taupe brown";
        imgUrl = "https://www.urbanrider.co.uk/media/catalog/product/cache/1/image/85e4522595efc69f496374d01ef2bf13/f/b/fbr042_7560mf_300rgb08.jpg";
        price = new Price(BigDecimal.valueOf(148.49), "usd");
        Product product10 = new Product(name, description, imgUrl, price, quantity, new Date());
        productRepository.save(product10);
        logger.info("SAVED PRODUCT - id: " + product10.getId());

        name = "John Doe daytona boots - brown";
        imgUrl = "https://www.urbanrider.co.uk/media/catalog/product/cache/1/image/85e4522595efc69f496374d01ef2bf13/d/a/daytona-main-72.jpg";
        price = new Price(BigDecimal.valueOf(170.00), "usd");
        Product product11 = new Product(name, description, imgUrl, price, quantity, new Date());
        productRepository.save(product11);
        logger.info("SAVED PRODUCT - id: " + product11.getId());

        name = "Red series Benny boots - oxblood";
        imgUrl = "https://www.urbanrider.co.uk/media/catalog/product/cache/1/image/85e4522595efc69f496374d01ef2bf13/b/e/benny_3.4.jpg";
        price = new Price(BigDecimal.valueOf(289.00), "usd");
        Product product12 = new Product(name, description, imgUrl, price, quantity, new Date());
        productRepository.save(product12);
        logger.info("SAVED PRODUCT - id: " + product12.getId());
    }
}