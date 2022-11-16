package com.example.carwashwebappbackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="telephone_nr")
    private String telephoneNr;

    @Column(name="password")
    private String password;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CarWash> carWashes;

    @OneToMany(mappedBy="customer", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Appointments> appointments;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="role_id")
    private Role role;
}
