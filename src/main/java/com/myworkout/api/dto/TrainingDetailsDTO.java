package com.myworkout.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDetailsDTO {

    private Long id;
    private Long levelOfAdvancementId;
    private Long trainingTypeId;
    private String name;
    private String description;

    @JsonProperty("exercises")
    private List<TrainingExerciseDTO> trainingExercises;
}
