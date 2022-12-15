package com.example.carwashwebappbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonIgnore
    private Set<CarWash> carWashes;

    @OneToMany(mappedBy="customer", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Appointments> appointments;

    @ManyToOne(
            fetch=FetchType.LAZY,
            optional = false,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            })
    @JoinColumn(name="role_id")
    @JsonManagedReference
    private Role role;

    @JsonIgnore
    public Role getRole() {
        return role;
    }

    @JsonProperty("role")
    public String getRoleName() {
        return role.getName();
    }
}
