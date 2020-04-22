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
@Table(name = "tranings")
public class Traning extends AbstractEntity {


    private String name;
    private String description;

    @OneToMany(mappedBy = "traning")
    private Set<TraningExercises> traningExercises = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "level_of_advancement_id", nullable = false)
    private LevelOfAdvancement levelOfAdvancement;

    @ManyToOne
    @JoinColumn(name = "traning_type_id", nullable = false)
    private TraningType traningType;
}
