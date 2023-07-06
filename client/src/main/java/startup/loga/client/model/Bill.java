package startup.loga.client.model;

import java.io.Serializable;
import java.util.Date;
public class Bill implements Serializable {

    private Long id;
    private Date billedAt;
    private String mode;
    private String reference;
    private Double amount;

    public Bill() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBilledAt() {
        return billedAt;
    }

    public void setBilledAt(Date billedAt) {
        this.billedAt = billedAt;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
