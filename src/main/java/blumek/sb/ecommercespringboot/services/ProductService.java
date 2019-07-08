package blumek.sb.ecommercespringboot.services;

import blumek.sb.ecommercespringboot.models.Product;

public interface ProductService {
    Iterable<Product> getAllProducts();
    Product getProductById(Integer id);
    Product saveProduct(Product product);
    void deleteProduct(Integer id);
    boolean exists(Integer id);
}
