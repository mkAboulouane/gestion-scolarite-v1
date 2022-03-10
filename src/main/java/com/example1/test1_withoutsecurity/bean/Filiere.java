package com.example1.test1_withoutsecurity.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Filiere implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomfiliere;  // sir, ieea


    public Filiere() {
    }

    public Long getId() {
        return id;
    }


    public Filiere(Long id, String nomfiliere) {
        this.id = id;
        this.nomfiliere = nomfiliere;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomfiliere() {
        return nomfiliere;
    }

    public void setNomfiliere(String nomfiliere) {
        this.nomfiliere = nomfiliere;
    }
}
