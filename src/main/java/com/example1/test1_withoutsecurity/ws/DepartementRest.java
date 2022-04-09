package com.example1.test1_withoutsecurity.ws;

import com.example1.test1_withoutsecurity.bean.Departement;
import com.example1.test1_withoutsecurity.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/gestion/departement")
public class DepartementRest {
    @Autowired
    private DepartementService departementService;

    @GetMapping("/{nom_depart}")
    public Departement findByNomDepartement(@PathVariable String nom_depart) {
        return departementService.findByNomDepartement(nom_depart);
    }

    @PostMapping("/")
    public int save(@RequestBody Departement departement) {
        return departementService.save(departement);
    }

    @GetMapping("/")
    public List<Departement> findAll() {
        return departementService.findAll();
    }
}
