package com.example1.test1_withoutsecurity.ws;

import com.example1.test1_withoutsecurity.bean.Seance;
import com.example1.test1_withoutsecurity.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/gestion/seance")
public class SeanceRest {
    @Autowired
    private SeanceService seanceService;

    @PostMapping("/")
    public String save(@RequestBody Seance seance) {
        return seanceService.save(seance);
    }

    @GetMapping("/findbyreference/reference/{reference}")
    public Seance findByReference(@PathVariable String reference) {
        return seanceService.findByReference(reference);
    }
//
//    @GetMapping("/findbydate/date_seance/{date_seance}")
//    public List<Seance> findByDate(@PathVariable Date date_Seance) {
//        return seanceService.findByDate(date_Seance);
//    }

    @GetMapping("/")
    public List<Seance> findAll() {
        return seanceService.findAll();
    }



}
