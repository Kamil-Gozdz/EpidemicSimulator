package com.app.epidemic.controller;

import com.app.epidemic.model.dto.SimulationDto;
import com.app.epidemic.service.simulation.SimulationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/simulation/")
@RequiredArgsConstructor
public class SimulationController {

    private final SimulationService simulationService;


    @GetMapping("all")
    public List<SimulationDto> getAllSimulation() {
        return simulationService.getAllSimulations();
    }
    @PostMapping("save")
    public SimulationDto save(@RequestBody SimulationDto simulationDto) {
        return simulationService.saveSimulation(simulationDto);
    }
    @PutMapping("update")
    public SimulationDto update(@Valid @RequestBody SimulationDto simulationDto) {
        return simulationService.updateSimulation(simulationDto);
    }
    @PatchMapping("part-update")
    public SimulationDto partUpdate(@Valid @RequestBody SimulationDto simulationDto) {
        return simulationService.updatePartSimulation(simulationDto);
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        simulationService.deleteSimulation(id);
    }
}
