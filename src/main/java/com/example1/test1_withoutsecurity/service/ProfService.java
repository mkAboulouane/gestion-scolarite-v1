package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.ProfDao;
import com.example1.test1_withoutsecurity.bean.Departement;
import com.example1.test1_withoutsecurity.bean.Prof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProfService {
    @Autowired
    private ProfDao profDao;

    public Prof findByEmail(String email) {
        return profDao.findByEmail(email);
    }

    @Autowired
    private DepartementService departementService;
    @Autowired
    private MatiereService matiereService;

    public Prof findByMatricule(String matr) {
        return profDao.findByMatricule(matr);
    }

    public int save(Prof prof) {
        Prof prof1 = profDao.findByCin(prof.getCin());
        Prof prof2 = profDao.findByMatricule(prof.getMatricule());
        Departement departement = departementService.findByNomDepartement(prof.getDepartement().getNom_Depart());

        if (prof.getCin() == null || prof.getMatricule() == null)
            return -1;
        else if (prof1!= null)
            return -2;
        else if (prof2!= null)
            return -3;
        else if (departement == null)
            return -4;
        else if (findByEmail(prof.getEmail()) != null)
            return -5;
        else {
            prof.setDepartement(departement);
            prof.setDate_Start_Work(new Date());
            profDao.save(prof);
            return 1;
        }

    }


    /*
    *Maven*
    validate
    build

     */
    public int update(Prof prof) {
        if(findByCin(prof.getCin())==null) return -1;
        else {
            profDao.save(prof);
            return 1;
        }
    }

    public Prof findByCin(String cin) {
        return profDao.findByCin(cin);
    }

    public List<Prof> findByDepartProf(String nom_dep) {
        return profDao.findByDepartProf(nom_dep);
    }

    public List<Prof> findAll() {
        return profDao.findAll();
    }

}
