package com.app.epidemic.service.simulation;

import com.app.epidemic.model.dto.SimulationDto;

import java.util.List;

public interface SimulationService {

   List<SimulationDto> getAllSimulations();

   SimulationDto saveSimulation(SimulationDto simulationDto);

   SimulationDto updateSimulation(SimulationDto simulationDto);

   SimulationDto updatePartSimulation(SimulationDto simulationDto);

   void deleteSimulation(Long id);


}
