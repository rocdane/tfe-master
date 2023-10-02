package startup.loga.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Repair implements Serializable
{
    private Long id;
    private String reference;
    private Date createdAt;
    private String description;
    private Integer mileage;
    private Boolean approved;
    private Integer totalSpare;
    private Integer totalTask;
    private Integer total;
    private String totalLetter;
    private Boolean billed;
    private String dossier;
    private String profile;
    private List<Task> tasks = new ArrayList<>();
    private List<Spare> spares = new ArrayList<>();

    public Integer getTotalSpare() {
        for (Spare spare : this.getSpares()) {
            this.totalSpare += spare.getAmount();
        }
        return this.totalSpare;
    }

    public Integer getTotalTask() {
        for (Task task : this.getTasks()) {
            this.totalTask += task.getCost();
        }
        return this.totalTask;
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }

    public void addSpare(Spare spare){
        this.spares.add(spare);
    }

    @Override
    public String toString() {
        return reference;
    }
}
