package startup.loga.client.app.factory;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Stats {
    private Integer dossiers, diagnosis, tasks, spares;
}
