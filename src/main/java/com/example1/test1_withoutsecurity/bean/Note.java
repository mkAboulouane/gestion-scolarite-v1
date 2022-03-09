package com.example1.test1_withoutsecurity.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private String note_reference = "N" + id;
    private Double resultat;    ///
    private String remarque;
    private Date date_note;
    /*

Inscription : nheydha bnesba l prof
id__ : id
last_name : last_Name
matiere relie to filliere
note : matiere + filliere + student + nveau
niveau : s1 ....
seance : abcense + matiere + filliere +
seance -> prof + matiere
delete the column @
bean : User () + Role ()
java : algorthme de hashage sha1,md9
paswword : compared to hash
algorithme hash : ne re arrive pas
algorithme de cryptage : crypt et decrypt

    */

    @ManyToOne
    private Student student;


    @OneToOne// Verified
    private Matiere matiere;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public Note() {
    }

    public Note(Double resultat, Student student, Matiere matiere, Date date_note) {
        this.resultat = resultat;
        this.student = student;
        this.matiere = matiere;
        this.date_note = date_note;
    }

    @Temporal(TemporalType.DATE)
    public Date getDate_note() {
        return date_note;
    }

    public void setDate_note(Date date_note) {
        this.date_note = date_note;
    }

    public Double getResultat() {
        return resultat;
    }

    public void setResultat(Double resultat) {
        this.resultat = resultat;
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
