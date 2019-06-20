package blumek.sb.ecommercespringboot.models;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Embedded
    private Price price;
    @Embedded
    private Quantity quantity;
    @Column(name = "CreatedAt")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
