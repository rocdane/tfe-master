package startup.loga.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Dossier implements Serializable
{
    private Long id;
    private String reference;
    private Date openAt;
    private Date updatedAt;
    private Client client;
    private Automobile automobile;

    @Override
    public String toString() {
        return reference;
    }
}
