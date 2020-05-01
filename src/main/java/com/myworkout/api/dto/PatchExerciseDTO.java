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

    // TODO: 29.04.2020 czy tak powinna wygladać klasa patch? Czy tutaj powinny byc id? - ok
    private String name;
    private Long bodyPartId;
    private Long levelOfAdvancementId;
    private Long exercisePhotosId;
}
