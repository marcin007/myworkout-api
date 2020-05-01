package com.myworkout.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessionDTO {

    private LocalDateTime startedAt;
    private int duration;
    private String comment;
    // TODO: 29.04.2020 brakuje atrybutów userId / username..


}
