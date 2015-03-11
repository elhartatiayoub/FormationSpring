package com.intelcia.model;

import javax.persistence.*;

/**
 * Created by Administrateur on 04/03/2015.
 */

@Entity
@Table
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    @ManyToOne(fetch=FetchType.EAGER)
    private Person parent;



    public Child(String name, int age, Person parent) {
        this.name = name;
        this.age = age;
        this.parent = parent;
    }

    public Child() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getParent() {
        return parent;
    }

    public void setParent(Person parent) {
        this.parent = parent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
