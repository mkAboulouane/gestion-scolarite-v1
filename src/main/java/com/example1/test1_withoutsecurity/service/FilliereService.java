package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.FiliereDao;
import com.example1.test1_withoutsecurity.bean.Filiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilliereService {

    public int save(Filiere filiere)
    {
        if(filiereDao.findByNom_Filiere(filiere.getNom_Filiere())!=null) return -1;
        else if(filiere.getNom_Filiere()==null) return -2;
        else {
            filiereDao.save(filiere);
            return 1;
        }
    }

    public List<Filiere> findAll() {
        return filiereDao.findAll();
    }

    public Filiere findByNom_filiere(String nom_filiere) {
        return filiereDao.findByNom_Filiere(nom_filiere);
    }


    @Autowired
    private FiliereDao filiereDao;


}
