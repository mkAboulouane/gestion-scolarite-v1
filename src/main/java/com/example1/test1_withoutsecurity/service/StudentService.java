package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.StudentDao;
import com.example1.test1_withoutsecurity.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.GeneratedValue;
import java.util.List;

@Service
public class StudentService {

    public String save(Student student) {
        if(student.getCne()==null) return "cne n'est pas insere !";
        else if(student.getApoge()==null) return "code apoge pas insere !";
        else if (findByApoge(student.getApoge()) != null) return "code Apoges deja existe !";
        else if (findByCne(student.getCne()) != null) return "cne deja existe!";
        else if (filiereService.findByNom_filiere(student.getFiliere().getNom_Filiere()) == null)  return "filiere n'existe pas!";
        else if (niveauService.findBySemestre(student.getNiveau().getSemestre()) == null) return "niveau n'existe pas!";
        else {
            student.setNiveau(niveauService.findBySemestre(student.getNiveau().getSemestre()));
            student.setFiliere(filiereService.findByNom_filiere(student.getFiliere().getNom_Filiere()));
            studentDao.save(student);
            return "Succes";
        }
    }

    public List<Student> findAll() {
        return studentDao.findAll();
    }

    public Student findByApoge(String apoge) {
        return studentDao.findByApoge(apoge);
    }

    @Query("SELECT student from Student student where student.niveau.semestre=:semstre and student.filiere.nom_Filiere=:nom_Fil")
    public List<Student> findSameNiveauAndFilliere(String semstre, String nom_Fil) {
        return studentDao.findSameNiveauAndFilliere(semstre, nom_Fil);
    }

    @Query("SELECT student from Student student where student.niveau.semestre=:semstre")
    public List<Student> findSameNiveau(String semstre) {
        return studentDao.findSameNiveau(semstre);
    }

    @Query("SELECT student from Student student where student.filiere.nom_Filiere=:nom_Fil")
    public List<Student> findSameFilliere(String nom_Fil) {
        return studentDao.findSameFilliere(nom_Fil);
    }

//    @Transactional
//    public int deleteByApoge(String apoge) {
//        if(findByApoge(apoge)==null) return -1;
//        else {
//            studentDao.deleteByApoge(apoge);
//            return 1;
//        }
//    }

    public Student findByCne(String cne) {
        return studentDao.findByCne(cne);
    }

    @Autowired
    private NiveauService niveauService;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private FilliereService filiereService;

}
