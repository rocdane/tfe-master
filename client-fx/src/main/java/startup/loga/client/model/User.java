package startup.loga.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable
{
    private Long id;
    private String username;
    private String email;
    private String password;
    private String role;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
