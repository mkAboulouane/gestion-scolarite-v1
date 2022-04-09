package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.SeanceDao;
import com.example1.test1_withoutsecurity.bean.Matiere;
import com.example1.test1_withoutsecurity.bean.Seance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SeanceService {

    @Autowired
    private SeanceDao seanceDao;
    @Autowired
    private MatiereService matiereService;

    public List<Seance> findSeanceInDate(Date date) {
        return seanceDao.findSeanceInDate(date);
    }

    public List<Seance> findSeanceInSalle(String salle) {
        return seanceDao.findSeanceInSalle(salle);
    }

    public int save(Seance seance) {
        Matiere matiere = matiereService.findByMatiereNom(seance.getMatiere().getName_Matiere());
        Seance seance1 = seanceDao.findByDateAndSalle(seance.getDate_Seance(), seance.getSalle(), seance.getHeure());
        if (findByReference(seance.getReference()) != null) {
            return -1;
        } else if (seance1 != null)
            return -2;
        else if (matiere == null) {
            return -3;
        } else {
            seance.setMatiere(matiere);
            Long i = seanceDao.SeanceReferenceIncrement();
//            seance.setDate_Seance(new Date());
            if (i == null) i = 0L;
            seance.setReference("S" + (1 + i));
            seanceDao.save(seance);
            return 1;
        }
    }

    public Seance findByReference(String reference) {
        return seanceDao.findByReference(reference);
    }

//    public List<Seance> findByDate(Date date_Seance) {
//        return seanceDao.findByDate(date_Seance);
//    }

    public List<Seance> findAll() {
        return seanceDao.findAll();
    }
}
