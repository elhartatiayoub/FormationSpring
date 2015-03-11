package com.intelcia.service;

import com.intelcia.dto.PersonDTO;
import com.intelcia.model.Person;

import java.util.List;


public interface PersonService {

    public Person create(PersonDTO created);

    public Person delete(Integer personId) ;

    public List<Person> findAll();


    public Person findById(Integer id);

    public List<Person> findByName(String name);



}