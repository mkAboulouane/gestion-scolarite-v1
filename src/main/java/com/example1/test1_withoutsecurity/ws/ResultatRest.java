package com.example1.test1_withoutsecurity.ws;

import com.example1.test1_withoutsecurity.bean.Resultat;
import com.example1.test1_withoutsecurity.service.ResultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/gestion/resultat")
public class ResultatRest {
    @Autowired
    private ResultatService resultatService;

    @GetMapping("/{apoges}/{matiere}")
    public List<Double> getResultatByMatiere(@PathVariable String apoges,@PathVariable String matiere) {
        return resultatService.getResultatByMatiere(apoges, matiere);
    }

    @GetMapping("/moyenne/{apoges}/{matiere}")
    public Double findMoyenneByMatiere(@PathVariable String apoges,@PathVariable String matiere) {
        return resultatService.findMoyenneByMatiere(apoges, matiere);
    }
}
