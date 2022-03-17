package com.example1.test1_withoutsecurity.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "professeur")
public class Prof implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //    @Email
    private String email;
    private String last_Name;
    // reference
    private String cin;
    // reference
    private String matricule;
    private String diplom;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date_Start_Work;

    @ManyToOne(cascade = CascadeType.ALL)
    private Departement departement;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
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
