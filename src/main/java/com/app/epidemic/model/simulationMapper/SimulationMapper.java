package com.app.epidemic.model.simulationMapper;

import com.app.epidemic.model.dto.SimulationDto;
import com.app.epidemic.model.entity.Simulation;

public interface SimulationMapper {
    static SimulationDto toDto(Simulation simulation){
        return SimulationDto.builder()
                .id(simulation.getId())
                .N(simulation.getN())
                .P(simulation.getP())
                .I(simulation.getI())
                .R(simulation.getR())
                .M(simulation.getM())
                .Ti(simulation.getTi())
                .Tm(simulation.getTm())
                .Ts(simulation.getTs())
                .build();
    }

    static Simulation toEntity(SimulationDto simulationDto){
        return Simulation.builder()
                .id(simulationDto.getId())
                .N(simulationDto.getN())
                .P(simulationDto.getP())
                .I(simulationDto.getI())
                .R(simulationDto.getR())
                .M(simulationDto.getM())
                .Ti(simulationDto.getTi())
                .Tm(simulationDto.getTm())
                .Ts(simulationDto.getTs())
                .build();
    }
}
