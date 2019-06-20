package blumek.sb.ecommercespringboot.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "Country")
    private String country;
    @Column(name = "City")
    private String city;
    @Column(name = "ZipCode")
    private String zipCode;
    @Column(name = "Street")
    private String street;
    @Column(name = "House")
    private String house;
    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
