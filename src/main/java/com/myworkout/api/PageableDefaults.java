package com.myworkout.api;

import org.springframework.data.domain.Sort;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface  PageableDefaults {

    int maxSize() default 1000;

    int minSize() default 0;

    int size() default 10;

    int page() default 0;

    String[] sort() default {};

    Sort.Direction direction() default Sort.Direction.ASC;
}
