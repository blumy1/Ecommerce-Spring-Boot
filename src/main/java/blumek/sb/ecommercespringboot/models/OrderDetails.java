package blumek.sb.ecommercespringboot.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer id;
    @OneToOne
    private Product product;
    @Embedded
    private Quantity quantity;
    @Embedded
    private Price price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Order order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
