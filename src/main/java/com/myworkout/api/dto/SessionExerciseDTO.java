package com.myworkout.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessionExerciseDTO {


    private Long sessionId;
    private Long exerciseId;

    private int reps;
    private int sets;
    private int orderNumber;
    private int time;
    private String tempo;
    private String description;
}
