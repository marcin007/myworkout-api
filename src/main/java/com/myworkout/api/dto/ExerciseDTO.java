package com.myworkout.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDTO {


    private Long id;
    private String name;
    private Long userId;
    private Long bodyPartId;
    private Long levelOfAdvancementId;
    private List<ExercisePhotoDTO> exercisePhotos; //bo chce zeby sie wyswietlaly wszyskie zdjecia
}
