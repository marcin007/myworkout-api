package com.myworkout.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatchExerciseDTO {

    private String name;
    private Long bodyPartId;
    private Long levelOfAdvancementId;
}
