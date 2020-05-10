package com.myworkout.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingExerciseDTO {

    private Long trainingId;
    private Long exerciseId;

    private int reps;
    private int sets;
    private int time;
    private int orderNumber;

}
