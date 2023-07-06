package startup.loga.client.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Finance implements Serializable {

    private Long id;

    private Date date;

    private Atelier atelier;

    private List<Recipe> recipes = new ArrayList<>();

    private List<Spent> spents = new ArrayList<>();

    public Finance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Atelier getAtelier() {
        return atelier;
    }

    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Spent> getSpents() {
        return spents;
    }

    public void setSpents(List<Spent> spents) {
        this.spents = spents;
    }

    public void addRecipe(Recipe recipe){
        recipe.setFinance(this);
        this.recipes.add(recipe);
    }

    public Double getTotalRecipe(){
        double total = 0;
        for (Recipe recipe :getRecipes()) {
            total+= recipe.getValue();
        }
        return total;
    }

    public void addSpent(Spent spent){
        spent.setFinance(this);
        this.spents.add(spent);
    }

    public Double getTotalSpent(){
        double total=0;
        for (Spent spent :getSpents()) {
            total+= spent.getValue();
        }
        return total;
    }
}
