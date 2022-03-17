package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.InscriptionDao;
import com.example1.test1_withoutsecurity.bean.Inscription;
import com.example1.test1_withoutsecurity.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InscriptionService {
    @Autowired
    private InscriptionDao inscriptionDao;
    @Autowired
    private StudentService studentService;

    public String save(Inscription inscription) {
        Student student = studentService.findByApoge(inscription.getStudent().getApoge());
        Inscription entity = inscriptionDao.findByInscription(inscription.getStudent().getApoge());
        if (student == null) return "student Doesn't exist";
        else if (entity != null) return "Inscription ce etudiant deja existe";
        else {
            inscription.setDate_Inscription(new Date());
            inscription.setStudent(student);
            inscriptionDao.save(inscription);
            return "Succes";
        }
    }

    public Inscription findByInscription(String apoges) {
        return inscriptionDao.findByInscription(apoges);
    }
}
