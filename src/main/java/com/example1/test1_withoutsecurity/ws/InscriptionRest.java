package com.example1.test1_withoutsecurity.ws;

import com.example1.test1_withoutsecurity.bean.Inscription;
import com.example1.test1_withoutsecurity.bean.Student;
import com.example1.test1_withoutsecurity.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gestion/incription")
public class InscriptionRest {

    @PostMapping("/")
    public String save(@RequestBody Inscription inscription) {
        return inscriptionService.save(inscription);
    }

    @PutMapping("/")
    public String update(@RequestBody Inscription inscription) {
        return inscriptionService.update(inscription);
    }

    @GetMapping("/cin/{cin}")
    public List<Inscription> findByStudent(@RequestBody Student student) {
        return inscriptionService.findByStudent(student);
    }

    @GetMapping("/")
    public List<Inscription> findAll() {
        return inscriptionService.findAll();
    }

    @Autowired
    private InscriptionService inscriptionService;
}
