package com.app.epidemic.model.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class Population implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer Pi;

    private Integer Pv;

    private Integer Pm;

    private Integer Pr;


    public Population() {

    }
}
