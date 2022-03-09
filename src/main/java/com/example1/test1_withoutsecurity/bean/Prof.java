package com.example1.test1_withoutsecurity.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "professeur")
public class Prof {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prof;
    private String name;
    private String last_name;
    private String cin;
    private String matricule;
    private String diplom;
    private Date date_start_work;

    @OneToOne(mappedBy = "prof")         // Verified
    private Inscription inscription;


    @ManyToOne(cascade = CascadeType.ALL)
    private Departement departement;


    @OneToOne(mappedBy = "prof")
    private Matiere matiere;



    public Prof() {
    }

    public Prof(Long id_Prof, String name, String last_name, String cin, String matricule, String diplom, Date date_start_work, Inscription inscription) {
        this.id_prof = id_Prof;
        this.name = name;
        this.last_name = last_name;
        this.cin = cin;
        this.matricule = matricule;
        this.diplom = diplom;
        this.date_start_work = date_start_work;
        this.inscription = inscription;
    }

    public Long getId_prof() {
        return id_prof;
    }

    public void setId_prof(Long id_prof) {
        this.id_prof = id_prof;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDiplom() {
        return diplom;
    }

    public void setDiplom(String diplom) {
        this.diplom = diplom;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    @Temporal(TemporalType.DATE)
    public Date getDate_start_work() {
        return date_start_work;
    }

    public void setDate_start_work(Date date_start_work) {
        this.date_start_work = date_start_work;
    }
}
