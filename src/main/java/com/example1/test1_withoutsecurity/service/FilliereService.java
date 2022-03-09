package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.FiliereDao;
import com.example1.test1_withoutsecurity.bean.Filiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilliereService {
    public List<Filiere> findAll() {
        return filiereDao.findAll();
    }
//
//    public Filiere findByNom_filiere(String nom_filiere) {
//        return filiereDao.findByNom_filiere(nom_filiere);
//    }

    @Autowired
    private FiliereDao filiereDao;


}
