package com.example1.test1_withoutsecurity.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_departement;

    private String nom_departement;
    @JsonIgnore
    @OneToMany(mappedBy = "departement")                    // Verified
    private List<Matiere> matieres;

    @JsonIgnore
    @OneToMany(mappedBy = "departement")
    private List<Prof> prof;

    public Departement() {
    }

    public Long getId_departement() {
        return id_departement;
    }

    public void setId_departement(Long id_departement) {
        this.id_departement = id_departement;
    }

    public String getNom_departement() {
        return nom_departement;
    }

    public void setNom_departement(String nom_departement) {
        this.nom_departement = nom_departement;
    }

    public List<Matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }
}
