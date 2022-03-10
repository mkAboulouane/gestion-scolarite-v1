package com.example1.test1_withoutsecurity.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Absence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;

    private Date date_Absence;
    private boolean justife;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Seance seance;


    public Absence(Long id, String reference, Date date_Absence, boolean justife, Student student, Seance seance) {
        this.id = id;
        this.reference = reference;
        this.date_Absence = date_Absence;
        this.justife = justife;
        this.student = student;
        this.seance = seance;
    }

    public Absence() {
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public void setId_abs(Long id_abs) {
        this.id = id;
    }

    public Long getId_abs() {
        return id;
    }


    @Temporal(TemporalType.DATE)
    public Date getDate_absence() {
        return date_Absence;
    }

    public void setDate_absence(Date date_absence) {
        this.date_Absence = date_Absence;
    }

    public boolean isJustife() {
        return justife;
    }

    public void setJustife(boolean justife) {
        this.justife = justife;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDate_Absence() {
        return date_Absence;
    }

    public void setDate_Absence(Date date_Absence) {
        this.date_Absence = date_Absence;
    }

}
