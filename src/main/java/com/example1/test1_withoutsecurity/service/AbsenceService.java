package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.AbsenceDao;
import com.example1.test1_withoutsecurity.bean.Absence;
import com.example1.test1_withoutsecurity.bean.Seance;
import com.example1.test1_withoutsecurity.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceService {

    @Autowired
    private AbsenceDao absenceDao;
    @Autowired
    private MatiereService matiereService;
    @Autowired
    private StudentService studentservice;
    @Autowired
    private SeanceService seanceService;

    public String save(Absence absence) {
        Student student = studentservice.findByApoge(absence.getStudent().getApoge());
        Seance seance = seanceService.findByReference(absence.getSeance().getReference());
        if (absenceDao.findByReference(absence.getReference()) != null) return "Absence deja unregister";
        else if (student == null) return "student n exist pas";
        else if (seance == null) return "seance n exist pas";
        else {
            Long i = absenceDao.absenceReferenceIncremet();
            if (i == null) i = 0L;
            absence.setReference("A" + (1 + i));
            absence.setStudent(student);
            absence.setSeance(seance);
            absenceDao.save(absence);
            return "Success";
        }
    }

    public List<Absence> findParStudent(String absence_stu, String absence_mat) {
        return absenceDao.findParStudent(absence_stu, absence_mat);
    }

    public Absence findByReference(String refrence) {
        return absenceDao.findByReference(refrence);
    }

    public List<Absence> findParSeance(String absence_sea) {
        return absenceDao.findParSeance(absence_sea);
    }

    public List<Absence> findAll() {
        return absenceDao.findAll();
    }

    public Absence findAllAbsenceStudent(String apoges) {
        return absenceDao.findAllAbsenceStudent(apoges);
    }
}
