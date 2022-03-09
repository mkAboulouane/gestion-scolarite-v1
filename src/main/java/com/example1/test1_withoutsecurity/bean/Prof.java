package com.example1.test1_withoutsecurity.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "professeur")
public class Prof {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String last_Name;
    private String cin;
    private String matricule;
    private String diplom;
    private Date date_Start_Work;


    @ManyToOne(cascade = CascadeType.ALL)
    private Departement departement;


    @OneToOne(mappedBy = "prof")
    private Matiere matiere;



    public Prof() {
    }

    public Prof(Long id, String name, String last_name, String cin, String matricule, String diplom, Date date_start_work) {
        this.id = id;
        this.name = name;
        this.last_Name = last_name;
        this.cin = cin;
        this.matricule = matricule;
        this.diplom = diplom;
        this.date_Start_Work = date_start_work;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
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

    @Temporal(TemporalType.DATE)
    public Date getDate_Start_Work() {
        return date_Start_Work;
    }

    public void setDate_Start_Work(Date date_Start_Work) {
        this.date_Start_Work = date_Start_Work;
    }
}
