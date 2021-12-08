package com.example.service;

import com.example.model.Person;
import com.example.repository.HelloWorldRepository;
import org.modelmapper.ModelMapper;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class HelloWorldServiceImpl implements HelloWorldService{
    private HelloWorldRepository helloWorldRepository;
    private ModelMapper modelMapper;
    @Inject
    public HelloWorldServiceImpl(HelloWorldRepository helloWorldRepository,ModelMapper modelMapper) {
        this.helloWorldRepository = helloWorldRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public List<Person> getAllPeople() {
        return helloWorldRepository.listAll();
    }

    @Override
    public Long addPerson(Person person) {
        return helloWorldRepository.savePerson(person);
    }

    @Override
    @Transactional
    public Person updatePerson(Person person,Long id) {
        Person personToUpdate=helloWorldRepository.findByIdOptional(id).orElseThrow(()-> new NotFoundException("No person found with id"));
        Long saveId=person.getId();
        modelMapper.map(person,personToUpdate);
        personToUpdate.setId(id);
        return personToUpdate;


    }

    @Override
    @Transactional
    public Person deletePerson(Long id) {
        Person personToDelete=helloWorldRepository.findByIdOptional(id).orElseThrow(()-> new NotFoundException("No person found with id"));
        helloWorldRepository.delete(personToDelete);
        return personToDelete;

    }
}
