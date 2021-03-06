package com.myworkout.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "session_exercises")
public class SessionExercise implements Serializable {

    @EmbeddedId
    private SessionExerciseId id;

    @ManyToOne
    @MapsId("sessionId")
    private Session session;

    @ManyToOne
    @MapsId("exerciseId")
    private Exercise exercise;

    private int reps;
    private int sets;
    private int orderNumber;
    private int time;
    private String tempo;
    private String description;

    public Integer getReps() {
        return reps;
    }

    public Integer getSets() {
        return sets;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public Integer getTime() {
        return time;
    }
}
