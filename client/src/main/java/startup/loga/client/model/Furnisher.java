package startup.loga.client.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Furnisher implements Serializable
{
    private Long id;
    private String name;
    private String address;
    private String contact;
    private List<Order> orders = new ArrayList<>();

    public Furnisher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
