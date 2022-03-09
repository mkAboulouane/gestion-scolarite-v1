package com.example1.test1_withoutsecurity.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "filiere")
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_filiere;
    @JoinColumn(name = "filliere", nullable = false, updatable = false)
    private String nom_filiere;  // sir, ieea

//
//     @ManyToMany            //(mappedBy = "filieres")         // Verified
//     private List<Prof> prof1;

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

    @Column(name = "id")
    public Long getId() {
        return id_filiere;
    }

    @Column(name = "nom_filiere", length = 45, nullable = false)
    public String getNom_filiere() {
        return nom_filiere;
    }


    public void setNom_filiere(String nom_filiere) {
        this.nom_filiere = nom_filiere;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setId(Long id) {
        this.id_filiere = id_filiere;
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
