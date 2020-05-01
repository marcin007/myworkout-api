package com.myworkout.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDTO {

    private String name;
    private Long userId;
    private Long bodyPartId;
    private Long levelOfAdvancementId;
    private Long exercisePhotosId;
}
