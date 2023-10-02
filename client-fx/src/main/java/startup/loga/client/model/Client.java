package startup.loga.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Client implements Serializable
{
    private Long id;
    private String name;
    private String type;
    private String legalNotice;
    private String address;
    private String contact;
}
