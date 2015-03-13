package com.intelcia.repo;

import com.intelcia.dto.PersonDTO;
import com.intelcia.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrateur on 09/03/2015.
 */
public interface PersonRepo extends CrudRepository<Person,Integer> ,PersonRepoCustom{
    @Transactional
//    @Query("SELECT p FROM Person p WHERE LOWER(p.name) = LOWER(:name)")
    @Query("SELECT new com.intelcia.dto.PersonDTO(p) FROM com.intelcia.model.Person p WHERE LOWER(p.name) = LOWER(:name)  ")
    public List<PersonDTO> find(@Param("name") String name);
//    @Query("SELECT p FROM Person p WHERE LOWER(p.name) = LOWER(:name)")
//    public List<Person> find(@Param("name") String name);
//    @Query(value = "SELECT * as Clazz_ FROM PERSON  WHERE NAME = ?1",nativeQuery = true)
//    public Person findByName(String name);

    public List<Person> findByNameIgnoreCase(String name);
}
