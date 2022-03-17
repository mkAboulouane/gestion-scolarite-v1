package com.example1.test1_withoutsecurity.ws;

import com.example1.test1_withoutsecurity.bean.Inscription;
import com.example1.test1_withoutsecurity.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gestion/incription")
public class InscriptionRest {
    @Autowired
    private InscriptionService inscriptionService;

    @PostMapping("/")
    public String save(@RequestBody Inscription inscription) {
        return inscriptionService.save(inscription);
    }

    @GetMapping("/apoges/{apoges}")
    public Inscription findByInscription(@PathVariable String apoges) {
        return inscriptionService.findByInscription(apoges);
    }


}
