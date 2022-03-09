package com.example1.test1_withoutsecurity.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Niveau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Niveau;
    private String semestre; // s5 s1 ....

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="filliere_id",nullable = false)   // Verified
    private Filiere filiere;

    @JsonIgnore
    @OneToMany(mappedBy = "niveau")         // Verified
    private List<Student> students;


    @JsonIgnore
    @OneToMany(mappedBy = "niveau")               // New
    private List<Matiere> matieress;


    public Niveau() {
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Long getId_Niveau() {
        return id_Niveau;
    }

    public void setId_Niveau(Long id_Niveau) {
        this.id_Niveau = id_Niveau;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
