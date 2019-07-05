package blumek.sb.ecommercespringboot.controllers;

import blumek.sb.ecommercespringboot.models.Product;
import blumek.sb.ecommercespringboot.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/{id}")
    public Product getProduct(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product saveProducts(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping(value = "/{id}")
    public Product updateProducts(@RequestBody Product product, @PathVariable Integer id) {
        product.setId(id);
        return productService.saveProduct(product);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }
}
