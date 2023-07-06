package startup.loga.client.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evaluation implements Serializable {

    private Long id;

    private Date createdAt;

    private Integer grade;

    private String observation;

    private Profile profile;
    private List<Criteria> criteria = new ArrayList<>();

    public Evaluation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Criteria> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<Criteria> criteria) {
        for (Criteria item : criteria) {
            item.setEvaluation(this);
        }
        this.criteria = criteria;
    }

    public void addCriteria(Criteria criteria){
        criteria.setEvaluation(this);
        this.criteria.add(criteria);
    }
}
