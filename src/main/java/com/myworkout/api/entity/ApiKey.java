package com.myworkout.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("api_keys")
public class ApiKey extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String value;

    private Boolean hasExpired;

}
