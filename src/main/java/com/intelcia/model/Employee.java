package com.intelcia.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrateur on 04/03/2015.
 */
@Entity
@PrimaryKeyJoinColumn(name = "ID")
//@DiscriminatorValue("emp")
public class Employee extends Person {
    private String entrprise;
    private int salary;
    @ManyToMany(mappedBy="equip",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Projet> projets;

    public String getEntrprise() {
        return entrprise;
    }

    public void setEntrprise(String entrprise) {
        this.entrprise = entrprise;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    public Employee() {
        projets = new ArrayList<Projet>();
    }

    public Employee(String name, int age, String address, String entrprise, int salary) {
        super(name, age, address);
        this.entrprise = entrprise;
        this.salary = salary;
        this.projets = new ArrayList<Projet>();
    }

    public void addProjet(Projet projet){
        projets.add(projet);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge()  +
                ", entrprise='" + entrprise + '\'' +
                ", salary=" + salary +
                '}';
    }
}
