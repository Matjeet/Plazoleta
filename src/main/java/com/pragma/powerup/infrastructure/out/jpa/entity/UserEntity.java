package com.pragma.powerup.infrastructure.out.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "documentId")
    private String documentId;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "birthDate")
    private LocalDate birthDate;
    private String email;
    private String password;
    private int roleId;
}
