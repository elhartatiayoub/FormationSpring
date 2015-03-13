package com.intelcia.repo;

import com.intelcia.model.Child;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Administrateur on 10/03/2015.
 */
public interface ChildRepo extends CrudRepository<Child,Integer> {
    List<Child> getByParentId(int id);
}
