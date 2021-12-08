package com.example.repository;

import com.example.model.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class HelloWorldRepository implements PanacheRepository<Person> {
    @Transactional
    public Long savePerson(Person person){
        persist(person);
        return person.getId();
    }

}
