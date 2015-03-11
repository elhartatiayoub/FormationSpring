package com.intelcia.repo;

import com.intelcia.model.Person;

public class PersonRepoImpl implements PersonRepoCustom {

  public void customMethod(Person person) {
      System.out.println("a person "+person);
  }
}