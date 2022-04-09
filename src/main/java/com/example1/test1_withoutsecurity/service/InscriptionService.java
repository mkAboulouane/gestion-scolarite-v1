package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.InscriptionDao;
import com.example1.test1_withoutsecurity.bean.Inscription;
import com.example1.test1_withoutsecurity.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InscriptionService {

    public List<Inscription> findAll() {
        return inscriptionDao.findAll();
    }

    @Autowired
    private InscriptionDao inscriptionDao;
    @Autowired
    private StudentService studentService;

    public int save(Inscription inscription) {
        Student student = studentService.findByApoge(inscription.getStudent().getApoge());
        Inscription entity = inscriptionDao.findByInscription(inscription.getStudent().getApoge());

        if (student == null) return -1;
        else if (entity != null) return -2;
        else {
            inscription.setDate_Inscription(new Date());
            inscription.setStudent(student);
            inscriptionDao.save(inscription);
            return 1;
        }
    }

    public Inscription findByInscription(String apoges) {
        return inscriptionDao.findByInscription(apoges);
    }
}
