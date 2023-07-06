package startup.loga.client.model;

import java.io.Serializable;
import java.util.Date;
public class Log implements Serializable
{
    private Long id;
    private String event;
    private String description;
    private Date at;
    private AuthSession authSession;

    public Log() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAt() {
        return at;
    }

    public void setAt(Date at) {
        this.at = at;
    }

    public AuthSession getAuthSession() {
        return authSession;
    }

    public void setAuthSession(AuthSession authSession) {
        this.authSession = authSession;
    }
}
