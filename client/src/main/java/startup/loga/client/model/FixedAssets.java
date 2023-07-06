package startup.loga.client.model;

import java.io.Serializable;
import java.util.Date;

public class FixedAssets implements Serializable {

    private Long id;
    private String category;
    private String designation;
    private String code;
    private Date entryDate;
    private Float depreciationRate;
    private Atelier atelier;

    public FixedAssets() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Float getDepreciationRate() {
        return depreciationRate;
    }

    public void setDepreciationRate(Float depreciationRate) {
        this.depreciationRate = depreciationRate;
    }

    public Atelier getAtelier() {
        return atelier;
    }

    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }
}
