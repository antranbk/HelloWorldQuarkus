package com.example.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;


import javax.inject.Singleton;

public class HelloWorldConfiguration {
    @Singleton
    public ModelMapper createModelMapper(){
        return new ModelMapper();
    }
}
