package startup.loga.client.model;

import java.io.Serializable;

public class Factor implements Serializable {

    private Long id;

    private String entity;

    private String dysfunction;

    private String maintenance;

    private Diagnosis diagnosis;

    public Factor() {
    }

    public Factor(String entity, String dysfunction, String maintenance) {
        this.entity = entity;
        this.dysfunction = dysfunction;
        this.maintenance = maintenance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getDysfunction() {
        return dysfunction;
    }

    public void setDysfunction(String dysfunction) {
        this.dysfunction = dysfunction;
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }
}
