package startup.loga.client.app.factory;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Diagnoses {
    private Integer count;
    private Date period;
}
