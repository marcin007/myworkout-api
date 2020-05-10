package com.myworkout.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDTO {

    private Long id;
    private Long userId;
    private Long levelOfAdvancementId;
    private Long trainingTypeId;
    private String name;
    private String description;

}
