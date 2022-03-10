package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.FiliereDao;
import com.example1.test1_withoutsecurity.bean.Filiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.util.List;

@Service
public class FilliereService {

    public int save(Filiere filiere)
    {
        if(filiereDao.findByNom_Filiere(filiere.getNomfiliere())!=null) return -1;
        else if(filiere.getNomfiliere()==null) return -2;
        else {
            filiereDao.save(filiere);
            return 1;
        }
    }

//    @Transactional
//    public int deleteByNomfiliere(String reference) {
//       return filiereDao.deleteByNomfiliere(reference);
//    }

    public List<Filiere> findAll() {
        return filiereDao.findAll();
    }

    public Filiere findByNom_filiere(String nom_filiere) {
        return filiereDao.findByNom_Filiere(nom_filiere);
    }


    @Autowired
    private FiliereDao filiereDao;


}
