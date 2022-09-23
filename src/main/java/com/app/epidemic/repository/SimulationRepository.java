package com.app.epidemic.repository;

import com.app.epidemic.model.entity.Simulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimulationRepository extends JpaRepository<Simulation,Long> {

}
