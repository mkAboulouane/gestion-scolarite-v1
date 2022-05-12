package com.example1.test1_withoutsecurity.service;

import com.example1.test1_withoutsecurity.Dao.AbsenceDao;
import com.example1.test1_withoutsecurity.bean.Absence;
import com.example1.test1_withoutsecurity.bean.Seance;
import com.example1.test1_withoutsecurity.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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

    public int save(Absence absence) {
        Student student = studentservice.findByApoge(absence.getStudent().getApoge());
        Seance seance = seanceService.findByReference(absence.getSeance().getReference());
        Absence absence1 = absenceDao.findByReference(absence.getReference());
//        Absence entity = findStudentSeance(absence.getSeance().getReference(),absence.getStudent().getApoge());
        if (absence1 != null) return -1;
        else if (student == null) return -2;
        else if (seance == null) return -3;
//        else if (entity!=null) return -4;
        else {
            Long i = absenceDao.absenceReferenceIncremet();
            if (i == null) i = 0L;
            absence.setReference("A" + (1 + i));
            absence.setStudent(student);
            absence.setSeance(seance);
            absenceDao.save(absence);
            return 1;
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
