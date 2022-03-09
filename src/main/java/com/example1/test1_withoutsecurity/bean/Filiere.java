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

    @JsonIgnore
    @OneToMany(mappedBy = "filiere")        // Verified
    private List<Student> students;

    @JsonIgnore
    @OneToMany(mappedBy = "filiere")            // Verified
    private List<Matiere> matieres;

    @JsonIgnore
    @OneToMany(mappedBy = "filiere")     // Verified
    private List<Niveau> niveaux;

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }

    public List<Niveau> getNiveaux() {
        return niveaux;
    }

    public void setNiveaux(List<Niveau> niveaux) {
        this.niveaux = niveaux;
    }
}
