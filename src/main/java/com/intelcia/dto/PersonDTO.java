package com.intelcia.dto;

import com.intelcia.model.Child;
import com.intelcia.model.Person;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class PersonDTO {
    
    private int id;

    private String Name;

    private String adresse;

    private List<Integer> children;

    private int age;

    public PersonDTO(int id, String name, String adresse, int age, List<Child> children) {
        this.id = id;
        Name = name;
        this.adresse = adresse;
        this.age = age;

        if(children!=null)
            for(Child child:children) {
                this.children.add(child.getId());
            }
    }

    public PersonDTO(Person p) {
        this.id = p.getId();
        Name = p.getName();
        this.adresse = p.getAddress();
        this.age = p.getAge();
        children= new ArrayList<Integer>();
        if(p.getChildren()!=null)
            for(Child child:p.getChildren()) {
                this.children.add(child.getId());
            }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PersonDTO() {
        children = new ArrayList<Integer>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Integer> getChildren() {
        return children;
    }

    public void setChildren(List<Integer> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}