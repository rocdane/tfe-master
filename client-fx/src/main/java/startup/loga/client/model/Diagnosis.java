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
public class Diagnosis implements Serializable {
    private Long id;
    private Date createdAt;
    private Integer mileage;
    private String description;
    private List<Factor> factors = new ArrayList<>();
    private String profile;
    private String dossier;

    public void addFactor(Factor factor) {
        factors.add(factor);
    }
}
