package startup.loga.client.model;

import java.io.Serializable;
import java.util.Date;

public class AuthSession implements Serializable
{

    private Long id;

    private String host;

    private String token;

    private Boolean closed;

    private Date dateCreate;

    private Date dateClose;

    private User user;

    public AuthSession() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateClose() {
        return dateClose;
    }

    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
