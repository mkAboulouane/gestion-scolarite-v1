package com.example1.test1_withoutsecurity.ws;

import com.example1.test1_withoutsecurity.bean.Matiere;
import com.example1.test1_withoutsecurity.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gestion/matiere")
public class MatiereRest {

    @PostMapping("/")
    public String save(@RequestBody Matiere matiere) {
        return matiereService.save(matiere);
    }
    @GetMapping("/{nom}/")
    public Matiere findByMatiereNom(@PathVariable String nom) {
        return matiereService.findByMatiereNom(nom);
    }
    @GetMapping("/")
    public List<Matiere> findAll() {
        return matiereService.findAll();
    }

    @Autowired
    private MatiereService matiereService;
}
