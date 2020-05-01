package com.myworkout.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Integer age;
    private Double weight;
    private Double height;

    @OneToMany(mappedBy = "user")
    private Set<UserPhoto> userPhotos = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Training> trainings = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Session> sessions = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
}
