package com.example1.test1_withoutsecurity.service;


import com.example1.test1_withoutsecurity.Dao.DepartementDao;
import com.example1.test1_withoutsecurity.bean.Departement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {
    @Autowired
    private DepartementDao departementDao;

    public Departement findByNomDepartement(String nom_depart) {
        return departementDao.findByNomDepartement(nom_depart);
    }

    public String save(Departement departement)
    {
        if(findByNomDepartement(departement.getNom_Depart())!=null)
            return "departement deja existe";
        else {
         departementDao.save(departement);
         return "Succes";
        }
    }

    public List<Departement> findAll() {
        return departementDao.findAll();
    }

}
