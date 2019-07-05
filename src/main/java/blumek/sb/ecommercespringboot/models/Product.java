package blumek.sb.ecommercespringboot.models;

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
    @Column(name = "Description")
    @Lob
    private String description;
    @Column(name = "ImageUrl")
    private String imageUrl;
    @Embedded
    private Price price;
    @Embedded
    private Quantity quantity;
    @Column(name = "CreatedAt")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public Product() {
    }

    public Product(String name, String description, String imageUrl, Price price, Quantity quantity, Date createdAt) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.quantity = quantity;
        this.createdAt = createdAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
