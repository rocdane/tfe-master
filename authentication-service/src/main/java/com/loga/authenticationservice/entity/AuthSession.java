package com.loga.authenticationservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.loga.authenticationservice.vendor.security.Crypto;
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

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "users", referencedColumnName = "id")
    @Transient
    private User user;

    public AuthSession() {
        this.setToken(Crypto.getInstance().generateToken(128));
    }
}
