package com.example1.test1_withoutsecurity.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern="yyyy-mm-dd--hh")
    private Date date_Seance;

    @ManyToOne
    private Matiere matiere;

    public Seance() {
    }

    public Seance(Long id, Date date_Seance, Matiere matiere) {
        this.id = id;
        this.date_Seance = date_Seance;
        this.matiere = matiere;
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
