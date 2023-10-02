package startup.loga.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Notice implements Serializable
{
    private Long id;
    private String code;
    private String checkpoint;
    private String status;
    private Reception reception;

    public Notice(String code, String checkpoint, String status){
        this.code=code;
        this.checkpoint=checkpoint;
        this.status=status;
    }
}
