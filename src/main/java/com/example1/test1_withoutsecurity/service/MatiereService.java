package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.MatiereDao;
import com.example1.test1_withoutsecurity.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService {
    @Autowired
    private MatiereDao matiereDao;
    @Autowired
    private FilliereService filliereService;
    @Autowired
    private ProfService profService;
    @Autowired
    private DepartementService departementService;
    @Autowired
    private NiveauService niveauService;

    public String save(Matiere matiere)
    {
        Matiere matieireEntity = findByMatiereNom(matiere.getName_Matiere());
        Filiere filiereEntity = filliereService.findByNom_filiere(matiere.getFiliere().getNomfiliere());
        Niveau niveauEntity = niveauService.findBySemestre(matiere.getNiveau().getSemestre());

        Departement departementEntity = departementService.findByNomDepartement(matiere.getDepartement().getNom_Depart());
//      Prof profEntity = profService.findByCin(matiere.getProf().getCin());
        if(matiere==null) return "matiere n'existe pas";
        else if(matiere.getName_Matiere()==null) return "inserer le nom du matiere";
        else if(matiere.getFiliere().getNomfiliere()==null) return "inserer le nom du fiiliere";
        else if(matiere.getDepartement().getNom_Depart()==null) return "inserer le nom de departement";
        else if(matiere.getNiveau().getSemestre()==null) return "inserer la semestre du matiere";
//      else if(matiere.getProf().getCin()==null && matiere.getProf().getMatricule()==null) return "inserer le cin ou la matricule de prof";
        else if(matieireEntity!=null) return "matiere deja existe";
        else if(filiereEntity==null) return "filiere n'existe pas";
        else if(niveauEntity==null) return "niveau n'existe pas";
        else if(departementEntity == null) return "departement n'existe pas";
//        else if(profEntity==null) return "professeur n'existe pas";
        else {
            matiere.setFiliere(filiereEntity);
            matiere.setDepartement(departementEntity);
            matiere.setNiveau(niveauEntity);
//          matiere.setProf(profEntity);
            matiereDao.save(matiere);
            return "Succes";
        }
    }

    public Matiere findByMatiereNom(String nom) {
        return matiereDao.findByMatiereNom(nom);
    }

    public List<Matiere> findAll() {
        return matiereDao.findAll();
    }
}
