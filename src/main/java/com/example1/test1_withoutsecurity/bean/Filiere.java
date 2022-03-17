package com.example1.test1_withoutsecurity.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Filiere implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomfiliere;  // sir, ieea


    public Filiere() {
    }

    public Filiere(Long id, String nomfiliere) {
        this.id = id;
        this.nomfiliere = nomfiliere;
    }

    public Long getId() {
        return id;
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
