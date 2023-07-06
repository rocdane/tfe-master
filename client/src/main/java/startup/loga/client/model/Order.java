package startup.loga.client.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Serializable
{
    private Long id;

    private Furnisher furnisher;

    private List<Spare> spares = new ArrayList<>();

    private Integer quantity;

    private Double amount;

    private Date createdAt;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Furnisher getFurnisher() {
        return furnisher;
    }

    public void setFurnisher(Furnisher furnisher) {
        this.furnisher = furnisher;
    }

    public List<Spare> getSpares() {
        return spares;
    }

    public void setSpares(List<Spare> spares) {
        this.spares = spares;
    }

    public Integer getQuantity() {
        int total = 0;
        for (Spare spare : spares) {
            total+= spare.getQuantity();
        }
        quantity = total;
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        double total=0;
        for (Spare spare : spares) {
            total+= spare.getQuantity();
        }
        return total;
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
