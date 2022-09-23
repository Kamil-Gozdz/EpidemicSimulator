package com.app.epidemic.model;

import com.app.epidemic.model.entity.Simulation;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Person {

    public Person(){

    }

private Boolean infected;

private Boolean deceased;

private Boolean resist;

private Integer infectionTime;


}


