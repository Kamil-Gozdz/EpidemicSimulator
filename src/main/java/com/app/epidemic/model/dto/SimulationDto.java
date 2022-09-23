package com.app.epidemic.model.dto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimulationDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String N;
    @NotNull
    private Integer P;
    @NotNull
    private Integer I;
    @NotNull
    private Integer R;
    @NotNull
    private Integer M;
    @NotNull
    private Integer Ti;
    @NotNull
    private Integer Tm;
    @NotNull
    private Integer Ts;
}
