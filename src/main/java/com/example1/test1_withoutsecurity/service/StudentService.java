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
        if (student.getCne() == null) return "cne n'est pas insere !";
//        else if(student.getApoge()==null) return "code apoge pas insere !";
//        else if (findByApoge(student.getApoge()) != null) return "code Apoges deja existe !";
        else if (findByCne(student.getCne()) != null) return "cne deja existe!";
        else if (filiereService.findByNom_filiere(student.getFiliere().getNomfiliere()) == null)
            return "filiere n'existe pas!";
        else if (niveauService.findBySemestre(student.getNiveau().getSemestre()) == null) return "niveau n'existe pas!";
        else {
            student.setNiveau(niveauService.findBySemestre(student.getNiveau().getSemestre()));
            student.setFiliere(filiereService.findByNom_filiere(student.getFiliere().getNomfiliere()));
            Long i = studentDao.CodeApogeIncrement();
            student.setApoge("E" + (1 + i));
            studentDao.save(student);
            return "Succes, code apoge : " + student.getApoge() + " avec id: " + student.getId();
        }
    }


    public List<Student> findAll() {
        return studentDao.findAll();
    }

    public Student findByApoge(String apoge) {
        return studentDao.findByApoge(apoge);
    }

    public List<Student> findSameNiveauAndFilliere(String semstre, String nom_Fil) {
        return studentDao.findSameNiveauAndFilliere(semstre, nom_Fil);
    }

    public List<Student> findSameNiveau(String semstre) {
        return studentDao.findSameNiveau(semstre);
    }

    public List<Student> findSameFilliere(String nom_Fil) {
        return studentDao.findSameFilliere(nom_Fil);
    }


//    public void update(Student student)
//    {
//       if(findByApoge(student.getApoge())!=null) {
//                studentDao.save(student);
//       }
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

//    @Transactional
//    public int deleteByApoge(String apoge) {
//        int result_niveau = niveauService.deleteBySemestre(findByApoge(apoge).getNiveau().getSemestre());
//        int result_filiere= filiereService.deleteByNomfiliere(findByApoge(apoge).getFiliere().getNomfiliere());
//        Student student = studentDao.findByApoge(apoge);
//        student.setFiliere(null);
//        student.setNiveau(null);
//        update(student);
//        studentDao.deleteByApoge(apoge);
//        return 1;
//        return result_niveau+result_filiere+result_etudiant;
//    }
//    @Transactional
//    public int deleteByApoge(String apoge) {
//        if(findByApoge(apoge)==null) return -1;
//        else {
//            studentDao.deleteByApoge(apoge);
//            return 1;
//        }
//    }
