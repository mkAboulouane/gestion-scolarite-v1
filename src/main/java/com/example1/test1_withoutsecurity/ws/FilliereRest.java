package com.example1.test1_withoutsecurity.ws;

import com.example1.test1_withoutsecurity.bean.Filiere;
import com.example1.test1_withoutsecurity.service.FilliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gestion/filiere")
public class FilliereRest {
    @Autowired
    private FilliereService filliereService;

    @PostMapping("/")
    public int save(@RequestBody Filiere filiere) {
        return filliereService.save(filiere);
    }

    @GetMapping("/")
    public List<Filiere> findAll() {
        return filliereService.findAll();
    }

    @GetMapping("/{nom_filiere}")
    public Filiere findByNom_filiere(@PathVariable String nom_filiere) {
        return filliereService.findByNom_filiere(nom_filiere);
    }
}
