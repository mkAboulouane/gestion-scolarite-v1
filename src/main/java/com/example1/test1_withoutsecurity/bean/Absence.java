package com.example1.test1_withoutsecurity.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private String abs_reference = "A" + id_abs;
    private Date date_Absence;
    private boolean justife;

    @ManyToOne
    private Student student;

    @OneToOne
    private Matiere matiere;

    public Absence(Long id,Date date_Absence, boolean justife, Student student, Matiere matiere) {
        this.id = id;
        this.date_Absence = date_Absence;
        this.justife = justife;
        this.student = student;
        this.matiere = matiere;
    }

    public Absence() {
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

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
}
