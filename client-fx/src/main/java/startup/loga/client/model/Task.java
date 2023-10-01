package startup.loga.client.model;

import startup.loga.client.app.factory.Item;

import java.io.Serializable;

public class Task implements Serializable, Item
{
    private Long id;
    private String description;
    private Integer cost;
    private Integer duration;
    private Repair repair;

    public Task() {
    }

    public Task(String description, Integer cost) {
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

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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
    public Integer cost() {
        return cost;
    }
}
