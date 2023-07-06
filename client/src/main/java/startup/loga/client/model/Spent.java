package startup.loga.client.model;

import startup.loga.client.app.factory.ICashflow;

import java.io.Serializable;
import java.util.Date;

public class Spent implements ICashflow,Serializable {
    private Long id;
    private String description;
    private Double amount;
    private Date createdAt;
    private Finance finance;

    public Spent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Finance getFinance() {
        return finance;
    }

    public void setFinance(Finance finance) {
        this.finance = finance;
    }

    @Override
    public Double getValue() {
        return amount;
    }

    @Override
    public Date getDate() {
        return createdAt;
    }
}