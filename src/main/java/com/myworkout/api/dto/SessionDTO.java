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

    private Long id;
    private Long UserId;

    private String username;
    private LocalDateTime startedAt;
    private int duration;
    private String comment;

public Integer getDuration(){
    return duration;
}


}
