package startup.loga.client.model;

import startup.loga.client.app.factory.Item;

import java.io.Serializable;

public class Spare implements Serializable, Item
{
    private Long id;
    private String designation;
    private Integer price;
    private Integer quantity;
    private Integer amount;
    private Repair repair;

    public Spare() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    @Override
    public String name() {
        return designation;
    }

    @Override
    public Integer cost() {
        return amount;
    }
}
