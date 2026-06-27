package com.V2thaG.Spec.module2.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/// This configuration class defines and registers a ModelMapper bean in the Spring IoC container so it can be injected wherever needed.

@Configuration
public class MapperConfig {


    @Bean
    public ModelMapper getModelMapper(){
        // Creates a ModelMapper object and registers it as a Spring bean
        // in the IoC container so it can be injected wherever needed.
        return new ModelMapper();
    }
}
