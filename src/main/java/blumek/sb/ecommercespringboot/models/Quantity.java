package blumek.sb.ecommercespringboot.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Quantity {
    @Column(name = "Quantity")
    private double quantity;
    @Column(name = "Measure")
    private String measure;

    public Quantity() {
    }

    public Quantity(double quantity, String measure) {
        this.quantity = quantity;
        this.measure = measure;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
