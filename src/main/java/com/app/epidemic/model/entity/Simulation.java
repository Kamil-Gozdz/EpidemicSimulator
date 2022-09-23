package com.app.epidemic.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class Simulation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String N;

    private Integer P;

    private Integer I;

    private Integer R;

    private Integer M;

    private Integer Ti;

    private Integer Tm;

    private Integer Ts;

    public Simulation() {

    }
}
