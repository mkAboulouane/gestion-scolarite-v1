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

    public String save(Seance seance) {
        Matiere matiere = matiereService.findByMatiereNom(seance.getMatiere().getName_Matiere());
        if (findByReference(seance.getReference()) != null) {
            return "reference deja existe";
        } else if (seanceDao.findByDateAndSalle(seance.getDate_Seance(), seance.getSalle(), seance.getHeure()) != null)
            return "salle deja ocupe on ce date ;) Chercher une autre salle";
        else if (matiere == null) {
            return "aucune matiere trouvé";
        } else {
            seance.setMatiere(matiere);
            Long i = seanceDao.SeanceReferenceIncrement();
//            seance.setDate_Seance(new Date());
            if (i == null) i = 0L;
            seance.setReference("S" + (1 + i));
            seanceDao.save(seance);
            return "Succes";
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
