package com.example1.test1_withoutsecurity.ws;

import com.example1.test1_withoutsecurity.bean.Niveau;
import com.example1.test1_withoutsecurity.service.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gestion/niveau")
public class NiveauRest {

    @Autowired
    private NiveauService niveauService;

    @GetMapping("/semestre/{semestre}")
    public Niveau findBySemestre(@PathVariable String semestre) {
        return niveauService.findBySemestre(semestre);
    }

    @GetMapping("/")
    public List<Niveau> findAll() {
        return niveauService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Niveau niveau) {
        return niveauService.save(niveau);
    }
}
