package com.myworkout.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiInfo {

    private String name;
    private int code;
}
