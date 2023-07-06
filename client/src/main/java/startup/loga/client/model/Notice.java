package startup.loga.client.model;

import java.io.Serializable;
public class Notice implements Serializable
{
    private Long id;
    private String code;
    private String checkpoint;
    private String status;
    private Reception reception;

    public Notice() {
    }

    public Notice(String code, String checkpoint, String status){
        this.code=code;
        this.checkpoint=checkpoint;
        this.status=status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(String checkpoint) {
        this.checkpoint = checkpoint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Reception getReception() {
        return reception;
    }

    public void setReception(Reception reception) {
        this.reception = reception;
    }
}
