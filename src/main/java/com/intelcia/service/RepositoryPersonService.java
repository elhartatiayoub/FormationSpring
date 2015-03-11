package com.intelcia.service;

import com.intelcia.dto.PersonDTO;
import com.intelcia.model.Child;
import com.intelcia.model.Person;
import com.intelcia.repo.PersonRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RepositoryPersonService implements PersonService {
    

    @Resource
    private PersonRepo personRepo;

    @Transactional
    @Override
    public Person create(PersonDTO created) {

        Person person =  new Person();
        if(created.getChildren().isEmpty())
            person.setChildren(new ArrayList<Child>());
        else{
            //do something else
        }
        person.setAddress(created.getAdresse());
        person.setAge(created.getAge());
        person.setName(created.getName());
        return personRepo.save(person);
    }

    @Transactional
    @Override
    public Person delete(Integer personId)  {

        Person deleted = personRepo.findOne(personId);
        
        if (deleted == null) {
            System.out.println("No person found with id: " + personId);

        }
        
        personRepo.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> findAll() {

        return (List<Person>) personRepo.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Person findById(Integer id) {
        return personRepo.findOne(id);
    }

    @Override
    public List<Person> findByName(String name) {
        return personRepo.findByNameIgnoreCase(name);
    }


    protected void setPersonRepository(PersonRepo personRepository) {
        this.personRepo = personRepository;
    }
}