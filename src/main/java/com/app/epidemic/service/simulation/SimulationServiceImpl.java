package com.app.epidemic.service.simulation;

import com.app.epidemic.exception.SimulationNotFoundException;
import com.app.epidemic.model.dto.SimulationDto;
import com.app.epidemic.model.simulationMapper.SimulationMapper;
import com.app.epidemic.repository.SimulationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;


@Transactional
@Service
@RequiredArgsConstructor
public class SimulationServiceImpl implements SimulationService {

    private final SimulationRepository simulationRepository;

    @Override
    public List<SimulationDto> getAllSimulations() {
        return simulationRepository.findAll().stream()
                .map(SimulationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SimulationDto saveSimulation(SimulationDto simulationDto) {
        return SimulationMapper.toDto(simulationRepository.save(SimulationMapper.toEntity(simulationDto)));
    }

    @Override
    public SimulationDto updateSimulation(SimulationDto simulationDto) {
        return simulationRepository.findById(simulationDto.getId()).map(simulation -> {
            simulation.setN(simulationDto.getN());
            simulation.setP(simulationDto.getP());
            simulation.setI(simulationDto.getR());
            simulation.setR(simulationDto.getR());
            simulation.setM(simulationDto.getM());
            simulation.setTi(simulationDto.getTi());
            simulation.setTm(simulationDto.getTm());
            simulation.setTs(simulationDto.getTs());
            return SimulationMapper.toDto(simulation);
        }).orElseThrow(()->new SimulationNotFoundException("Not found simulation of id:" + simulationDto.getId()));
    }

    @Override
    public SimulationDto updatePartSimulation(SimulationDto simulationDto) {
        return simulationRepository.findById(simulationDto.getId()).map(simulation -> {
            if (nonNull(simulationDto.getN())) {
                simulation.setN(simulationDto.getN());
            }
            if (nonNull(simulationDto.getP())) {
                simulation.setP(simulationDto.getP());
            }
            if (nonNull(simulationDto.getI())) {
                simulation.setI(simulationDto.getI());
            }
            if (nonNull(simulationDto.getR())) {
                simulation.setR(simulationDto.getR());
            }
            if (nonNull(simulationDto.getM())) {
                simulation.setM(simulationDto.getM());
            }
            if (nonNull(simulationDto.getTi())) {
                simulation.setTi(simulationDto.getTi());
            }
            if (nonNull(simulationDto.getTm())) {
                simulation.setTm(simulationDto.getTm());
            }
            if (nonNull(simulationDto.getTs())) {
                simulation.setTs(simulationDto.getTs());
            }
            return SimulationMapper.toDto(simulation);
        }).orElseThrow(()->new SimulationNotFoundException("Not found simulation of id:" + simulationDto.getId()));
    }


    @Override
    public void deleteSimulation(Long id) {
        simulationRepository.deleteById(id);
    }

}
