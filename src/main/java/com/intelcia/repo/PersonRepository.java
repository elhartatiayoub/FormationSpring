package com.intelcia.repo;

import com.intelcia.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * Created by Administrateur on 11/03/2015.
 */
public interface PersonRepository extends JpaRepository<Person,Integer> {
    @Query(value = "SELECT p FROM Person p WHERE p.name LIKE :name")
    Page<Person> findByName(@Param("name")String name,Pageable page);
}
