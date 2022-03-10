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

    public String save(Seance seance){
        Matiere matiere=matiereService.findByMatiereNom(seance.getMatiere().getName_Matiere()) ;
        if(findByReference(seance.getReference())!=null){
            return "reference deja existe";
        }
        else if(matiere==null){
            return "aucune matiere trouvé";
        }else{
            seance.setMatiere(matiere);
            seanceDao.save(seance);
            return "Succes";
        }
    }

    public Seance findByReference(String reference) {
        return seanceDao.findByReference(reference);
    }

    public List<Seance> findByDate(Date date_Seance) {
        return seanceDao.findByDate(date_Seance);
    }

    public List<Seance> findAll() {
        return seanceDao.findAll();
    }
}
