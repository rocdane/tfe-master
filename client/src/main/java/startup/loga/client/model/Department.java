package startup.loga.client.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Department implements Serializable {
    private Long id;
    private String designation;
    private Atelier atelier;
    private List<Position> positions = new ArrayList<>();

    public Department() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Atelier getAtelier() {
        return atelier;
    }

    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public void addPosition(Position position){
        this.positions.add(position);
    }
}
