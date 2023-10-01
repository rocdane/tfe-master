package startup.loga.client.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repair implements Serializable
{
    private Long id;
    private String reference;
    private Date createdAt;
    private String description;
    private Integer mileage;
    private Boolean isApproved;
    private Double totalSpare;
    private Double totalTask;
    private Double total;
    private String totalLetter;
    private Boolean billed;
    private String dossier;
    private String profile;
    private List<Task> tasks = new ArrayList<>();
    private List<Spare> spares = new ArrayList<>();
    private Quality quality;

    public Repair() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public void setTotalSpare(Double totalSpare) {
        this.totalSpare = totalSpare;
    }

    public void setTotalTask(Double totalTask) {
        this.totalTask = totalTask;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getTotalLetter() {
        return totalLetter;
    }

    public void setTotalLetter(String totalLetter) {
        this.totalLetter = totalLetter;
    }

    public Boolean getBilled() {
        return billed;
    }

    public void setBilled(Boolean billed) {
        this.billed = billed;
    }

    public String getDossier() {
        return dossier;
    }

    public void setDossier(String dossier) {
        this.dossier = dossier;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Spare> getSpares() {
        return spares;
    }

    public void setSpares(List<Spare> spares) {
        this.spares = spares;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public Double getTotalSpare() {
        for (Spare spare : this.getSpares()) {
            this.totalSpare += spare.getAmount();
        }
        return this.totalSpare;
    }

    public Double getTotalTask() {

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

}
