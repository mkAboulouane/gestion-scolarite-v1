package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.StudentDao;
import com.example1.test1_withoutsecurity.bean.Filiere;
import com.example1.test1_withoutsecurity.bean.Inscription;
import com.example1.test1_withoutsecurity.bean.Niveau;
import com.example1.test1_withoutsecurity.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private NiveauService niveauService;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private FilliereService filiereService;
    @Autowired
    private InscriptionService inscriptionService;

    public int save(Student student) {
        Student student1 = findByCne(student.getCne());
        Niveau niveau =niveauService.findBySemestre(student.getNiveau().getSemestre());
        Filiere filiere =filiereService.findByNom_filiere(student.getFiliere().getNomfiliere());
        if (student.getCne() == null) return -1;
        else if ( student1!= null) return -2;
        else if (filiere == null)
            return -3;
        else if (niveau== null) return -4;
        else {
            student.setNiveau(niveau);
            student.setFiliere(filiere);
            Long i = studentDao.CodeApogeIncrement();
            if (i == null) i = 0L;
            student.setApoge("E" + (1 + i));
            studentDao.save(student);
            inscriptionService.save(new Inscription(student));
            return 1;
        }
    }

    public List<Student> findAll() {
        return studentDao.findAll();
    }

    public Student findByApoge(String apoge) {
        return studentDao.findByApoge(apoge);
    }
//
//    public void update(Student student)
//    {
//       if(findByApoge(student.getApoge())!=null) {
//                studentDao.save(student);
//       }
//    }

    public List<Student> findSameNiveauAndFilliere(String semstre, String nom_Fil) {
        return studentDao.findSameNiveauAndFilliere(semstre, nom_Fil);
    }

    public List<Student> findSameNiveau(String semstre) {
        return studentDao.findSameNiveau(semstre);
    }

    public List<Student> findSameFilliere(String nom_Fil) {
        return studentDao.findSameFilliere(nom_Fil);
    }

    public Student findByCne(String cne) {
        return studentDao.findByCne(cne);
    }

}

