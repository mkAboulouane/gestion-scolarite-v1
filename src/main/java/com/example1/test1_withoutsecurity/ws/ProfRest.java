package com.example1.test1_withoutsecurity.ws;

import com.example1.test1_withoutsecurity.bean.Prof;
import com.example1.test1_withoutsecurity.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gestion/prof")
public class ProfRest {
    @Autowired
    private ProfService profService;

    @PostMapping("/")
    public int save(@RequestBody Prof prof) {
        return profService.save(prof);
    }

    @PutMapping("/")
    public int update(@RequestBody Prof prof) {
        return profService.update(prof);
    }

    @GetMapping("/cin/{cin}")
    public Prof findByCin(@PathVariable String cin) {
        return profService.findByCin(cin);
    }

    @GetMapping("/")
    public List<Prof> findAll() {
        return profService.findAll();
    }

}
