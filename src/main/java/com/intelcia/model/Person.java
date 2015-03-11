package com.intelcia.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrateur on 03/03/2015.
 */
@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="Disc")
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person implements Comparable,Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private String address;
    @OneToMany(fetch=FetchType.EAGER, mappedBy="parent", cascade=CascadeType.ALL)
    private List<Child> children;

    

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public void addChild(Child child){ this.children.add(child); }

    public Person() {
        children = new ArrayList<Child>();
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.children = new ArrayList<Child>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", children=" + children +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o.getClass().equals(this.getClass())){
            Person p = (Person) o;
            if(p.getAge()>this.getAge())
                return -1;
            else if (p.getAge()<this.getAge())
                    return 1;
        }
        return 0;

    }
}
