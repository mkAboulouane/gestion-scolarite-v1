package com.example1.test1_withoutsecurity.service;


import com.example1.test1_withoutsecurity.Dao.FiliereDao;
import com.example1.test1_withoutsecurity.Dao.NiveauDao;
import com.example1.test1_withoutsecurity.bean.Niveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NiveauService {
    public Niveau findBySemestre(String semestre) {
        return niveauDao.findBySemestre(semestre);
    }
//    public int deleteBySemestre(String semestre)
//    {
//        int i = niveauDao.deleteById();
//    }

    public List<Niveau> findAll() {
        return niveauDao.findAll();
    }

    public int save(Niveau niveau)
    {
        if(niveauDao.findBySemestre(niveau.getSemestre())!=null) return -1;
//        else if(filiereDao.findByNom_Filiere(niveau.getFiliere().getNom_Filiere())==null) return -2;
        else {
//            niveau.setFiliere(filiereDao.findByNom_Filiere(niveau.getFiliere().getNom_Filiere()));
            niveauDao.save(niveau);
            return 1;
        }
    }

    @Autowired
    private FiliereDao filiereDao;
    @Autowired
    private NiveauDao niveauDao;
}
