package startup.loga.client.model;

import startup.loga.client.app.factory.Item;

import java.io.Serializable;

public class Task implements Serializable, Item
{
    private Long id;
    private String description;
    private Float cost;
    private Float hourly;
    private Float rate;
    private Repair repair;

    public Task() {
    }

    public Task(String description, Float cost) {
        this.description = description;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Float getHourly() {
        return hourly;
    }

    public void setHourly(Float hourly) {
        this.hourly = hourly;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    @Override
    public String name() {
        return description;
    }

    @Override
    public Float cost() {
        return cost;
    }
}
