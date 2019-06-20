package blumek.sb.ecommercespringboot.controllers;

import blumek.sb.ecommercespringboot.models.Product;
import blumek.sb.ecommercespringboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    public Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/product/{id}")
    public Product getProduct(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping(value = "/products")
    public Product saveProducts(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping(value = "/product/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }
}
