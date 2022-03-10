package com.example1.test1_withoutsecurity.ws;

import com.example1.test1_withoutsecurity.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gestion/incription")
public class InscriptionRest {
    @Autowired
    private InscriptionService inscriptionService;


}
