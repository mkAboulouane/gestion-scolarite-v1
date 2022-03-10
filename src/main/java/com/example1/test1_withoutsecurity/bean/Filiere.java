package com.example1.test1_withoutsecurity.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom_Filiere;  // sir, ieea


    public Filiere() {
    }

    public Long getId() {
        return id;
    }

    public String getNom_Filiere() {
        return nom_Filiere;
    }


    public void setNom_filiere(String nom_Filiere) {
        this.nom_Filiere = nom_Filiere;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom_Filiere(String nom_Filiere) {
        this.nom_Filiere = nom_Filiere;
    }
}
