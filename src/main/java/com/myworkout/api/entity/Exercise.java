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
@Table(name = "exercises")
public class Exercise extends AbstractEntity {

    private String name;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "body_part_id", nullable = false)
    private BodyPart bodyParts;

    @ManyToOne
    @JoinColumn(name = "level_of_advancement_id", nullable = false)
    private LevelOfAdvancement levelOfAdvancement;


    @OneToMany(mappedBy = "exercise")
    private Set<ExercisePhoto> exercisePhotos;

    @OneToMany(mappedBy = "exercise")
    private Set<SessionExercise> sessionExercises = new HashSet<>();

    @OneToMany(mappedBy = "exercise")
    private Set<TrainingExercises> trainingExercises = new HashSet<>();

}
