package startup.loga.client.model;

import java.io.Serializable;

public class Criteria implements Serializable {

    private Long id;
    private String code;
    private String designation;
    private Integer marking;
    private Integer mark;
    private Evaluation evaluation;

    public Criteria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getMarking() {
        return marking;
    }

    public void setMarking(Integer marking) {
        this.marking = marking;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }
}
