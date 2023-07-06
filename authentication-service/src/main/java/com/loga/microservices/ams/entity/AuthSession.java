package com.loga.microservices.ams.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.loga.microservices.ams.vendor.security.Crypto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "auth_session")
public class AuthSession implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "host")
    private String host;

    @Column(name = "token",unique = true,length = 128)
    private String token;

    @Column(name = "is_closed")
    private Boolean closed;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "closed_at")
    private Date closedAt;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "users", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
    private User user;

    public AuthSession() {
        this.setToken(Crypto.getInstance().generateToken(128));
    }
}
