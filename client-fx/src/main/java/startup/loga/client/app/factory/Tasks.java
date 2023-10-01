package startup.loga.client.app.factory;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Tasks {
    private Integer count;
    private Integer amount;
    private Date period;
}
