package com.myworkout.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatchSessionExerciseDTO {


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
