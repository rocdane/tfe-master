package startup.loga.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Factor implements Serializable {

    private Long id;

    private String entity;

    private String dysfunction;

    private String maintenance;

    private Diagnosis diagnosis;

    public Factor(String entity, String dysfunction, String maintenance) {
        this.entity = entity;
        this.dysfunction = dysfunction;
        this.maintenance = maintenance;
    }
}
