package startup.loga.client.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Delivery implements Serializable
{
    private Long id;
    private Order order;
    private List<Spare> spares;
    private Integer quantity;
    private Double amount;
    private Date createdAt;

    public Delivery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Spare> getSpares() {
        return spares;
    }

    public void setSpares(List<Spare> spares) {
        this.spares = spares;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
}
