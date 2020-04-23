package com.myworkout.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "training_exercises")
public class TrainingExercise implements Serializable {


    @EmbeddedId
    private TrainingExerciseId id;

    @ManyToOne
    @MapsId("exerciseId")
    private Exercise exercise;

    @ManyToOne
    @MapsId("trainingId")
    private Training training;

    private int reps;
    private int sets;
    private int time;
    private int orderNumber;
    private String description;
    private String tempo;
}
