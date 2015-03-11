package com.intelcia.service;

import com.intelcia.model.Projet;

import java.util.List;

/**
 * Created by Administrateur on 10/03/2015.
 */
public interface ProjetService {
    public Projet create(Projet created);

    public Projet delete(Integer ProjetId) ;

    public List<Projet> findAll();
}
