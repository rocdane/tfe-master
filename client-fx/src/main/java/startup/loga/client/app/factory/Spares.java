package startup.loga.client.app.factory;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Spares {
    private Integer count;
    private Integer amount;
    private Date period;
}
