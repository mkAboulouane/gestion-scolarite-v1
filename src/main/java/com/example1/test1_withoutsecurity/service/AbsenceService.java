package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.AbsenceDao;
import com.example1.test1_withoutsecurity.Dao.MatiereDao;
import com.example1.test1_withoutsecurity.Dao.StudentDao;
import com.example1.test1_withoutsecurity.bean.Absence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceService {

   public String save(Absence absence) {
       if (studentservice.findByApoge(absence.getStudent().getApoge())==null) return "student n existe pas";
       else if(seanceService.findByReference(absence.getReference())==null) return "seance n existe pas";
       else
       {
        absence.setStudent(studentservice.findByApoge(absence.getStudent().getApoge()));
        absence.setSeance(seanceService.findByReference(absence.getReference()));
        absenceDao.save(absence);
        return "Succes";
       }
   }

    public List<Absence> findParStudent(String absence_stu, String absence_mat) {
        return absenceDao.findParStudent(absence_stu, absence_mat);
    }

    public List<Absence> findParSeance(String absence_sea) {
        return absenceDao.findParSeance(absence_sea);
    }

    public List<Absence> findAll() {
        return absenceDao.findAll();
    }

    public Absence findAbsenceByReference(String reference) {
        return absenceDao.findAbsenceByReference(reference);
    }

    @Autowired
    private AbsenceDao absenceDao;
    @Autowired
    private MatiereService matiereService;
    @Autowired
    private StudentService studentservice;

    @Autowired
    private SeanceService seanceService;
}
