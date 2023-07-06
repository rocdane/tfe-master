package com.loga.microservices.ams.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
public class User implements Serializable
{
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;

    @Column(name = "username",unique = true,length = 50)
    private String username;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "is_active")
    private Boolean active=true;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
