package startup.loga.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import startup.loga.client.app.factory.Item;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Task implements Serializable, Item
{
    private Long id;
    private String description;
    private Integer cost;
    private Integer duration;

    public Task(String description, Integer cost) {
        this.description = description;
        this.cost = cost;
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
