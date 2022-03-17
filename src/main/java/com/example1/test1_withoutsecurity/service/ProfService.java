package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.ProfDao;
import com.example1.test1_withoutsecurity.bean.Prof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProfService {
    @Autowired
    private ProfDao profDao;
    @Autowired
    private DepartementService departementService;
    @Autowired
    private MatiereService matiereService;

    public Prof findByMatricule(String matr) {
        return profDao.findByMatricule(matr);
    }

    public String save(Prof prof) {
        if (prof.getCin() == null || prof.getMatricule() == null)
            return "inserer le CIN ou MATRICULE du prof";
        else if (profDao.findByCin(prof.getCin()) != null)
            return "prof CIN existe deja";
        else if (profDao.findByMatricule(prof.getMatricule()) != null)
            return "prof MATRICULE existe deja";
//          else if (matiereService.findByMatiereNom(prof.getMatiere().getName_Matiere())==null)
//            return "cette MATIERE n'existe pas";
        else if (departementService.findByNomDepartement(prof.getDepartement().getNom_Depart()) == null)
            return "DEPARTEMENT n'existe pas";
        else {
//            prof.setMatiere(matiereService.findByMatiereNom(prof.getMatiere().getName_Matiere()));
            prof.setDepartement(departementService.findByNomDepartement(prof.getDepartement().getNom_Depart()));
            prof.setDate_Start_Work(new Date());
            profDao.save(prof);
            return "Succes";
        }

    }


    /*
    *Maven*
    validate
    build

     */
    public String update(Prof prof) {
        profDao.save(prof);
        return "updateProf";
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
