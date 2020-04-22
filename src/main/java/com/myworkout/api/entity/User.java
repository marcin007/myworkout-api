package com.myworkout.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    private String password;
    private int age;
    private double weight;
    private double height;

    @OneToMany(mappedBy = "user")
    private Set<UserPhoto> userPhotos = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Traning> tranings = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Sesion> sesions = new HashSet<>();


}
