package com.example1.test1_withoutsecurity.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Seance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date_Seance;
    private String reference;
    private String salle;

    @ManyToOne
    private Matiere matiere;

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Seance() {
    }

    public Seance(Long id, Date date_Seance, String reference, String salle, Matiere matiere) {
        this.id = id;
        this.date_Seance = date_Seance;
        this.reference = reference;
        this.salle = salle;
        this.matiere = matiere;
    }

    public String getReference() {
        return reference;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getDate_Seance() {
        return date_Seance;
    }

    public void setDate_Seance(Date date_Seance) {
        this.date_Seance = date_Seance;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
}
