package com.example1.test1_withoutsecurity.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // reference
    private String nom_Depart;

//    @JsonIgnore
//    @OneToMany(mappedBy = "departement")                    // Verified
//    private List<Matiere> matieres;

//    @JsonIgnore
//    @OneToMany(mappedBy = "departement")
//    private List<Prof> prof;

    public Departement() {
    }

    public Departement(Long id, String nom_Depart) {
        this.id = id;
        this.nom_Depart = nom_Depart;
    }

    public Long getId_departement() {
        return id;
    }

    public void setId_departement(Long id_departement) {
        this.id = id;
    }

    public String getNom_departement() {
        return nom_Depart;
    }

    public void setNom_departement(String nom_depart) {
        this.nom_Depart = nom_Depart;
    }

//    public List<Matiere> getMatieres() {
//        return matieres;
//    }
//
//    public void setMatieres(List<Matiere> matieres) {
//        this.matieres = matieres;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_Depart() {
        return nom_Depart;
    }

    public void setNom_Depart(String nom_Depart) {
        this.nom_Depart = nom_Depart;
    }
}
