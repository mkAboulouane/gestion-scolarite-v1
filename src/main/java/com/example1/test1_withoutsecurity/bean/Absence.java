package com.example1.test1_withoutsecurity.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_abs;
    //private String abs_reference = "A" + id_abs;
    private Date date_absence;
    private boolean justife;

    @ManyToOne
    @JoinColumn(name="student_id",nullable = false) // Verified
    private Student student;

    @OneToOne
    @JoinColumn(name="matiere_id",nullable = false) // Verified
    private Matiere matiere;

    public Absence(Long id_abs,Date date_absence, boolean justife, Student student, Matiere matiere) {
        this.id_abs = id_abs;
        //this.abs_reference = abs_reference;
        this.date_absence = date_absence;
        this.justife = justife;
        this.student = student;
        this.matiere = matiere;
    }

    public Absence() {
    }


    public void setId_abs(Long id_abs) {
        this.id_abs = id_abs;
    }

//    public String getAbs_reference() {
//        return abs_reference;
//    }
//
//    public void setAbs_reference(String abs_reference) {
//        this.abs_reference = abs_reference;
//    }


    public Long getId_abs() {
        return id_abs;
    }


    @Temporal(TemporalType.DATE)
    public Date getDate_absence() {
        return date_absence;
    }

    public void setDate_absence(Date date_absence) {
        this.date_absence = date_absence;
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
