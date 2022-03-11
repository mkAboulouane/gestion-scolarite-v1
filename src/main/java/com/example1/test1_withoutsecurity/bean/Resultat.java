package com.example1.test1_withoutsecurity.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Resultat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double resultat;
    @ManyToOne
    private Matiere matiere;

    @ManyToOne
    private Student student;

    public Resultat() {
    }

    public Resultat(Long id, Double resultat, Matiere matiere, Student student) {
        this.id = id;
        this.resultat = resultat;
        this.matiere = matiere;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getResultat() {
        return resultat;
    }

    public void setResultat(Double resultat) {
        this.resultat = resultat;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
