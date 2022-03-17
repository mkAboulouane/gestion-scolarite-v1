package com.example1.test1_withoutsecurity.ws;

import com.example1.test1_withoutsecurity.bean.Absence;
import com.example1.test1_withoutsecurity.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gestion/absence")
public class AbsenceRest {
    @Autowired
    private AbsenceService absenceService;

    @PostMapping("/")
    public String save(@RequestBody Absence absence) {
        return absenceService.save(absence);
    }

    @GetMapping("/student/{absence_stu}/absence/{absence_mat}")
    public List<Absence> findParStudent(@PathVariable String absence_stu, @PathVariable String absence_mat) {
        return absenceService.findParStudent(absence_stu, absence_mat);
    }

    @GetMapping("/{absence_sea}/")
    public List<Absence> findParSeance(@PathVariable String absence_sea) {
        return absenceService.findParSeance(absence_sea);
    }

    @GetMapping("/")
    public List<Absence> findAll() {
        return absenceService.findAll();
    }

    //    @GetMapping("/reference/{reference}")
//    public Absence findAbsenceByReference(String reference) {
//        return absenceService.findAbsenceByReference(reference);
//    }

    @GetMapping("/student/{apoges}")
    public Absence findAllAbsenceStudent(@PathVariable String apoges) {
        return absenceService.findAllAbsenceStudent(apoges);
    }


}
