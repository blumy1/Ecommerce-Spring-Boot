package blumek.sb.ecommercespringboot.controllers;

import blumek.sb.ecommercespringboot.exceptions.EmptyResourceException;
import blumek.sb.ecommercespringboot.exceptions.IllegalIdException;
import blumek.sb.ecommercespringboot.exceptions.ResourceNotFoundException;
import blumek.sb.ecommercespringboot.exceptions.ResourceNotSaveableException;
import blumek.sb.ecommercespringboot.models.Product;
import blumek.sb.ecommercespringboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Object> getProducts() {
        Iterable<Product> products = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable Integer id) {
        if (id <= 0)
            throw new IllegalIdException();

        Product product = productService.getProductById(id);
        if (product == null)
            throw new ResourceNotFoundException(id);

        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
        if (product == null)
            throw new EmptyResourceException();

        if (product.getId() != null)
            product.setId(null);

        product.setCreatedAt(new Date());

        Product savedProduct = productService.saveProduct(product);
        if (savedProduct == null)
            throw new ResourceNotSaveableException();

        return ResponseEntity.status(HttpStatus.OK).body(savedProduct);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateProducts(@RequestBody Product product, @PathVariable Integer id) {
        if (id <= 0)
            throw new IllegalIdException();

        if (!productService.exists(id))
            throw new ResourceNotFoundException(id);

        product.setId(id);
        Product savedProduct = productService.saveProduct(product);
        if (savedProduct == null)
            throw new ResourceNotSaveableException();

        return ResponseEntity.status(HttpStatus.OK).body(savedProduct);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        if (id <= 0)
            throw new IllegalIdException();

        if (!productService.exists(id))
            throw new ResourceNotFoundException(id);

        productService.deleteProduct(id);
    }
}
