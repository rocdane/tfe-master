package startup.loga.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import startup.loga.client.app.factory.Item;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Spare implements Serializable, Item
{
    private Long id;
    private String designation;
    private Integer price;
    private Integer quantity;
    private Integer amount;

    @Override
    public String name() {
        return designation;
    }

    @Override
    public Integer cost() {
        return amount;
    }
}
