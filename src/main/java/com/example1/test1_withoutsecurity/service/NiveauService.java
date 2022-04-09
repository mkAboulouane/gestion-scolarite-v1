package com.example1.test1_withoutsecurity.service;


import com.example1.test1_withoutsecurity.Dao.NiveauDao;
import com.example1.test1_withoutsecurity.bean.Niveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NiveauService {

    @Transactional
    public int deleteBySemestre(String semestre) {
        return niveauDao.deleteBySemestre(semestre);
    }

    @Autowired
    private NiveauDao niveauDao;

    public Niveau findBySemestre(String semestre) {
        return niveauDao.findBySemestre(semestre);
    }

    public List<Niveau> findAll() {
        return niveauDao.findAll();
    }

    public int save(Niveau niveau) {
        Niveau niveau1 =niveauDao.findBySemestre(niveau.getSemestre());
        if (niveau1 != null) return -1;
        else if (niveau.getSemestre() == null) return -2;
        else {
            niveauDao.save(niveau);
            return 1;
        }
    }
}
