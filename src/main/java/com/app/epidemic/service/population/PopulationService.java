package com.app.epidemic.service.population;

import com.app.epidemic.model.Person;
import com.app.epidemic.model.entity.Population;

import java.util.List;

public interface PopulationService {

    List<Person> getPersons();

    Population getPopulation(List<Person> persons);

    Population getNextDay(Population population, List<Person> persons);

    List<Population> simulationDetails(Population population,List<Person> persons);

}
