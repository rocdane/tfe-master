package startup.loga.client.model;

import java.io.Serializable;
import java.util.Date;
public class Calendar implements Serializable {
	
    private Long id;
    private String title;
    private String content;
    private Date startAt;
    private Date endAt;
    private Boolean status;
    private Space space;
    private Profile profile;

    public Calendar() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
