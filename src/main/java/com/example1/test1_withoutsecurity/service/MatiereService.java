package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.MatiereDao;
import com.example1.test1_withoutsecurity.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    public int save(Matiere matiere) {
        Matiere matieireEntity = findByMatiereNom(matiere.getName_Matiere());
        Filiere filiereEntity = filliereService.findByNom_filiere(matiere.getFiliere().getNomfiliere());
        Niveau niveauEntity = niveauService.findBySemestre(matiere.getNiveau().getSemestre());

        Prof profEntity = profService.findByCin(matiere.getProf().getCin());

        if (matiere.getName_Matiere() == null) return -1;
        else if (matiere.getFiliere().getNomfiliere() == null) return -2;
        else if (matiere.getNiveau().getSemestre() == null) return -3;
        else if (matiere.getProf().getCin() == null)
            return -4;
        else if (matieireEntity != null) return -5;
        else if (filiereEntity == null) return -6;
        else if (niveauEntity == null) return -7;
        else if (profEntity == null) return -8;
        else {
            matiere.setFiliere(filiereEntity);
            matiere.setNiveau(niveauEntity);
            matiere.setProf(profEntity);
            matiereDao.save(matiere);
            return 1;
        }
    }

    public List<String> findMatiereInFiliereAndNiveau(String nom_fil, String nom_semestre) {
        return matiereDao.findMatiereInFiliereAndNiveau(nom_fil, nom_semestre);
    }

    public Matiere findByMatiereNom(String nom) {
        return matiereDao.findByMatiereNom(nom);
    }

    public List<Matiere> findAll() {
        return matiereDao.findAll();
    }
}
