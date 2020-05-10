package com.myworkout.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessionDetailsDTO {

    private Long id;
    private LocalDateTime startedAt;
    private int duration;
    private String comment;
    private String username;

    @JsonProperty("exercises")
    private List<SessionExerciseDTO> sessionExercises;
}
