package com.youtubeclone.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Data
public class UsersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String  mobile;
    String password;
    @Column(insertable = false,updatable = false)
    LocalDateTime created_at;

}
