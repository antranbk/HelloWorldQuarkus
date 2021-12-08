package com.example.service;

import com.example.model.Person;

import java.util.List;

public interface HelloWorldService {
    List<Person> getAllPeople();
    Long addPerson(Person person);
    Person updatePerson(Person person,Long id);
    Person deletePerson(Long id);
}
