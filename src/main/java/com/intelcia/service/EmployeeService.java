package com.intelcia.service;

import com.intelcia.model.Employee;

import java.util.List;

/**
 * Created by Administrateur on 10/03/2015.
 */
public interface EmployeeService {

    public Employee create(Employee created);

    public Employee delete(Integer EmployeeId) ;

    public List<Employee> findAll();
}
