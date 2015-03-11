package com.intelcia.repo;

import com.intelcia.model.Projet;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrateur on 10/03/2015.
 */

public interface ProjetRepo extends CrudRepository<Projet,Integer> {

    public List<Projet> findByDateLivraisonBetween(Date from,Date to);

    public List<Projet> findByEquipNameLike(String name);
}
