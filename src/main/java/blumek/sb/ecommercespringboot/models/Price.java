package blumek.sb.ecommercespringboot.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Price {
    @Column(name = "Amount")
    private BigDecimal amount;
    @Column(name = "Currency", nullable = false, length = 20)
    private String currency;

    public Price() {
    }

    public Price(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
