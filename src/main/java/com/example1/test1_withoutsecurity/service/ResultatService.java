package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.ResultatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultatService {

    @Autowired
    private ResultatDao resultatDao;

    @Autowired
    private MatiereService matiereService;

    @Autowired
    private StudentService studentService;

    public List<Double> getResultatByMatiere(String apoges, String matiere) {
        return resultatDao.getResultatByMatiere(apoges, matiere);
    }

    public Double findMoyenneByMatiere(String apoges, String matiere) {
        List<Double> result = resultatDao.getResultatByMatiere(apoges, matiere);
        Double somme = 0D;
        for (Double res : result)
            somme += res;

        return somme / (result.size());
    }

    public Double getMoyenneGeneral(String apoges) {

        List<String> matiere = matiereService.findMatiereInFiliereAndNiveau(studentService.findByApoge(apoges).getFiliere().getNomfiliere(), studentService.findByApoge(apoges).getNiveau().getSemestre());
        List<Double> note = new ArrayList<Double>();

        for (String mat : matiere) {
            Double i = findMoyenneByMatiere(apoges, mat);
            if (i == null || Double.isNaN(i)) return -1D;
            else note.add(i);
        }

        Double somme = 0D;

        for (Double res : note)
            somme += res;

        return somme / (note.size());
    }

}
