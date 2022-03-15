package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.InscriptionDao;
import com.example1.test1_withoutsecurity.bean.Inscription;
import com.example1.test1_withoutsecurity.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionService {

    public String save(Inscription inscription) {
        if (inscription.getStudent() != null)
            return "l'étudiant est déja inscrit";
        else if (inscription.getStudent().getCne() == null) {
            return "l'étudiant n'est encore inscrit";
        } else {
            inscriptionDao.save(inscription);
            return "success";
        }
    }

    public String update(Inscription inscription) {
        inscriptionDao.save(inscription);
        return "updateinscription";
    }


    public List<Inscription> findByStudent(Student student) {
        return inscriptionDao.findByStudent(student);
    }

    public List<Inscription> findAll() {
        return inscriptionDao.findAll();
    }

    @Autowired
    private InscriptionDao inscriptionDao;
    @Autowired
    private StudentService studentService;

}
