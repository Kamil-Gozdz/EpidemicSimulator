package com.app.epidemic.service.population;

import com.app.epidemic.model.Person;
import com.app.epidemic.model.entity.Population;
import com.app.epidemic.model.entity.Simulation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PopulationServiceImpl implements PopulationService {

    private final Simulation simulation;

    private final Person person;

    @Override
    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        int infectedCounter = 0;
        for (int i = 0; i < simulation.getP(); i++) {
            if (infectedCounter < simulation.getI()) {
                persons.add(new Person(true, false, false, 0));
                infectedCounter++;
            }
            persons.add(new Person(false, false, false, 0));
        }
        return persons;
    }

    @Override
    public Population getPopulation(List<Person> persons) {
        Long id = 0L;
        int Pi = 0;
        int Pv = 0;
        int Pm = 0;
        int Pr = 0;
        for (int i = 0; i < persons.size(); i++) {
            if (person.getInfected()) {
                Pi++;
            }
            Pv = simulation.getP() - Pi;
        }
        return new Population(id,Pi, Pv, Pm, Pr);
    }

    @Override
    public Population getNextDay(Population population, List<Person> persons) {
        int counterM = 0;
        int counterR = 0;
        for (Person p : persons) {
            if (p.getInfectionTime().equals(simulation.getTm())) {
                if (counterM < simulation.getM()) {
                    if (p.getInfected()) {
                        p.setInfected(false);
                        p.setDeceased(true);
                        population.setPm(population.getPm() + 1);
                        population.setPi(population.getPi() - 1);
                        counterM++;
                    }
                } else if (p.getInfectionTime().equals(simulation.getTi()))
                    if (p.getInfected()) {
                        p.setInfected(false);
                        p.setResist(true);
                        population.setPr(population.getPr() + 1);
                        population.setPi(population.getPi() - 1);
                    }
            } else if (!p.getInfected() && !p.getDeceased() && !p.getResist()) {
                if (counterR < simulation.getR() * population.getPi()) {
                    p.setInfected(true);
                    population.setPi(population.getPi() + 1);
                    population.setPv(population.getPv() - 1);
                    counterR++;
                }
            }
            if(p.getInfected()){
                p.setInfectionTime(p.getInfectionTime()+1);
            }
        }
        return new Population(population.getId(),
                population.getPi(),
                population.getPv(),
                population.getPm(),
                population.getPr());
    }

    @Override
    public List<Population> simulationDetails(Population population,List<Person> persons) {
        List<Population> populations = new ArrayList<>();
        for(int i = 0; i < simulation.getTs(); i++){
            Population nextDay = getNextDay(population, persons);
            populations.add(nextDay);
        }
        return populations;
    }
}
