package startup.loga.client.app.factory;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dashboard {
    private Stats stats;
    private List<Diagnoses> diagnoses = new ArrayList<>();
    private List<Tasks> tasks = new ArrayList<>();
    private List<Spares> spares = new ArrayList<>();
}
