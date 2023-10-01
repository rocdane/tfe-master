package startup.loga.client.app.factory;

import java.util.List;

public class Invoice {

    private List<Item> items;

    public void addItem(Item item){
        this.items.add(item);
    }

    public Integer calculateCost(){

        int total = 0;

        for (Item item:items) {
            total += item.cost();
        }

        return total;
    }
}
