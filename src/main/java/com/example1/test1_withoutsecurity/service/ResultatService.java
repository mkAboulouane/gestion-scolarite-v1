package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.ResultatDao;
import com.example1.test1_withoutsecurity.bean.Resultat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultatService {
@Autowired
    private ResultatDao resultatDao;

    public List<Double> getResultatByMatiere(String apoges, String matiere) {
        return resultatDao.getResultatByMatiere(apoges, matiere);
    }

    public Double findMoyenneByMatiere(String apoges, String matiere)
    {
        List<Double> result = resultatDao.getResultatByMatiere(apoges, matiere);
        Double somme = 0D;
        for(Double res : result)
        {
            somme +=res;
        }
        return somme/(result.size());
    }
}
