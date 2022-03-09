package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.FiliereDao;
import com.example1.test1_withoutsecurity.Dao.StudentDao;
import com.example1.test1_withoutsecurity.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
//    public String save(Student student)
//    {
//        if(studentDao.findByApoge(student.getApoge())!=null) return "code Apoges deja existe";
//        else if(studentDao.findByCne(student.getCne())!=null) return "cne deja existe";
////        else if(student.getFiliere().getNom_filiere()==null) return "filliere non inserer";
////        else if(student.getNiveau().getId_Niveau()==null) return "niveau non inserer";
//        else {
//            studentDao.save(student);
//            return "Succes";
//        }
//    }
//
//    public Optional<Student> findById1(Long id)
//    {
//        return studentDao.findById(id);
//
//    }
//    public List<Student> findAll() {
//        return studentDao.findAll();
//    }
//
//    public Student findByApoge(String apoge) {
//        return studentDao.findByApoge(apoge);
//    }
//
//    public List<Student> findSameNiveauAndFilliere(Long id_niveau, Long id_fil) {
//        return studentDao.findSameNiveauAndFilliere(id_niveau, id_fil);
//    }
//
//    public List<Student> findSameNiveau(Long id_niveau) {
//        return studentDao.findSameNiveau(id_niveau);
//    }
//
//    public List<Student> findSameFilliere(Long id_fil) {
//        return studentDao.findSameFilliere(id_fil);
//    }
//
//    @Transactional
//    public void deleteByApoge(String apoge) {
//        studentDao.deleteByApoge(apoge);
//    }
//
//    public Student findByCne(String cne) {
//        return studentDao.findByCne(cne);
//    }
//
//    @Autowired
//    private StudentDao studentDao;

//    @Autowired
//    private FilliereService filiereService;
    }
