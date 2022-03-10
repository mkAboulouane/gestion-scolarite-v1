package com.example1.test1_withoutsecurity.service;


import com.example1.test1_withoutsecurity.Dao.FiliereDao;
import com.example1.test1_withoutsecurity.Dao.NiveauDao;
import com.example1.test1_withoutsecurity.bean.Niveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NiveauService {
    public Niveau findBySemestre(String semestre) {
        return niveauDao.findBySemestre(semestre);
    }


//    @Transactional
//    public int deleteBySemestre(String semetre) {
//        return niveauDao.deleteBySemestre(semetre);
//    }

    public List<Niveau> findAll() {
        return niveauDao.findAll();
    }

    public int save(Niveau niveau)
    {
        if(niveauDao.findBySemestre(niveau.getSemestre())!=null) return -1;
        else if(niveau.getSemestre()==null) return -2;
        else {
            niveauDao.save(niveau);
            return 1;
        }
    }


    @Autowired
    private NiveauDao niveauDao;
}
