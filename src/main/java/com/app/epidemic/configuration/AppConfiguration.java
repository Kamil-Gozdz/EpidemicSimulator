package com.app.epidemic.configuration;


import com.app.epidemic.model.Person;
import com.app.epidemic.model.entity.Simulation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public Simulation simulationConfiguration(){
        return new Simulation();
    }
    @Bean
    public Person personConfiguration(){
        return new Person();
    }
}
