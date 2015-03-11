package com.intelcia.repo;

import com.intelcia.model.Employee;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrateur on 10/03/2015.
 */
public interface EmployeeRepo extends CrudRepository<Employee,Integer>,JpaSpecificationExecutor {
    @Transactional
    public List<Employee> findByNameLike(String name);
}
