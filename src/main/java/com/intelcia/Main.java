package com.intelcia;

import com.intelcia.dto.PersonDTO;
import com.intelcia.model.Child;
import com.intelcia.model.Employee;
import com.intelcia.model.Projet;
import com.intelcia.repo.EmployeeRepo;
import com.intelcia.repo.PersonRepo;
import com.intelcia.repo.PersonRepository;
import com.intelcia.repo.ProjetRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Administrateur on 09/03/2015.
 */

public class Main {

    public static void populate(){
        List<Employee> employeeList = new ArrayList<Employee>();
        List<Child> children = new ArrayList<Child>();
        Employee employee = new Employee("emp1",21,"add1","intelcia",123);
        children.add(new Child("bébé",2,employee));
        children.add(new Child("nana",2,employee));

        employee.setChildren(children);
        employeeList.add(employee);
        employeeList.add(new Employee("emp2",21,"add2","intesslcia",123));
        employeeList.add(new Employee("emp3",21,"add2","intelcia",123));
        employeeList.add(new Employee("chef1",21,"add2","intelcia",123));
        employeeList.add(new Employee("chef2",21,"add2","intelcia",123));

        Projet projet = new Projet("proj1",new Date());
        projet.setEquip(employeeList);
        Date past = new Date();
        past.setDate(new Date().getDate() -30);
        Projet projet1 = new Projet("projet2",past);

        ApplicationContext ctx = new AnnotationConfigApplicationContext(Conf.class);
        ProjetRepo projetRepo = ctx.getBean(ProjetRepo.class);
        projetRepo.save(projet);
        projetRepo.save(projet1);

    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Conf.class);
        PersonRepo personRepo =  ctx.getBean(PersonRepo.class);
        EmployeeRepo employeeRepo = ctx.getBean(EmployeeRepo.class);
        ProjetRepo projetRepo = ctx.getBean(ProjetRepo.class);
        PersonRepository personRepository  = ctx.getBean(PersonRepository.class);

        List<PersonDTO> list = personRepo.find("emp2");
        System.out.println(list);
//        projetRepo.findAll();
//        System.out.println(employeeRepo.findByNameLike("chef%"));
//        Date from = new Date();
//        from.setDate(new Date().getDate() -1);
//        System.out.println(projetRepo.findByDateLivraisonBetween(from, new Date()));
//        System.out.println(projetRepo.findByEquipNameLike("chef%"));
//        System.out.println(personRepo.find("chef1"));
//        personRepo.customMethod(null);
//        Page<Person> page= personRepository.findAll(new PageRequest(0, 5));
//        Page<Person> page= personRepository.findByName("emp%", new PageRequest(0, 5));
//        System.out.println(page.getContent());
//        System.out.println(per.findByName("chef1"));
//        System.out.println(employeeRepo.findAll(where(isPoor()).or(isWorking())));
    }
}
