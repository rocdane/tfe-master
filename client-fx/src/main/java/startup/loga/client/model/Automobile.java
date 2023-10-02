package startup.loga.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Automobile implements Serializable
{
    private Long id;
    private String number;
    private String vin;
    private String make;
    private String model;
    private Integer trim;
    private String unit;
}
