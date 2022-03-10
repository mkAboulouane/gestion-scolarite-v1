package com.example1.test1_withoutsecurity.ws;

import com.example1.test1_withoutsecurity.bean.Prof;
import com.example1.test1_withoutsecurity.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/prof")
public class ProfRest {
    @PostMapping("/")
    public String save(@RequestBody Prof prof) {
        return profService.save(prof);
    }

    @PutMapping("/")
    public String update(@RequestBody Prof prof) {
        return profService.update(prof);
    }

    @GetMapping("/cin/{cin}")
    public Prof findByCin(@PathVariable String cin) {
        return profService.findByCin(cin);
    }

//    @GetMapping("/")
//    public List<Prof> findByDepartProf(@PathVariable String nom_dep) {
//        return profService.findByDepartProf(nom_dep);
//    }

    @GetMapping("/")
    public List<Prof> findAll() {
        return profService.findAll();
    }

    @Autowired
    private ProfService profService;

}
