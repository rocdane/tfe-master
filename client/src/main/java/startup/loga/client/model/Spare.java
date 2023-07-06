package startup.loga.client.model;

import startup.loga.client.app.factory.Item;

import java.io.Serializable;

public class Spare implements Serializable, Item
{
    private Long id;
    private String designation;
    private Float price;
    private Integer quantity;
    private Float amount;
    private Boolean isOrdered = false;
    private Boolean delivered = false;
    private Order order;
    private Delivery delivery;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Boolean getOrdered() {
        return isOrdered;
    }

    public void setOrdered(Boolean ordered) {
        isOrdered = ordered;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
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
    public Float cost() {
        return amount;
    }
}
