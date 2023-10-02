package startup.loga.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AuthSession implements Serializable
{
    private Long id;

    private String host;

    private String token;

    private Boolean closed;

    private Date createdAt;

    private Date closedAt;

    private User user;
}
