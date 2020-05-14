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
@Table(name = "trainings")
public class Training extends AbstractEntity {



    private String name;
    private String description;
    private Boolean hasExpired;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "level_of_advancement_id", nullable = false)
    private LevelOfAdvancement levelOfAdvancement;

    @ManyToOne
    @JoinColumn(name = "training_type_id", nullable = false)
    private TrainingType trainingType;

    @OneToMany(mappedBy = "training", cascade = CascadeType.REMOVE)
    private Set<TrainingExercise> trainingExercises = new HashSet<>();


    public Training(String info) {
        this.description = info;
    }
}
