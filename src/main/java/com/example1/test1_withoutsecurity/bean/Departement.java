package com.example1.test1_withoutsecurity.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Departement implements Serializable {
    private static final long serialVersionUID = 1L;
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
