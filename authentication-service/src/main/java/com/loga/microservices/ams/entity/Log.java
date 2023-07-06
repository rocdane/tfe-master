package com.loga.microservices.ams.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "logs")
public class Log implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "event")
    private String event;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private Date at;

    @ManyToOne(targetEntity = AuthSession.class)
    @JoinColumn(name="sessions",referencedColumnName="id")
    private AuthSession authSession;
}
