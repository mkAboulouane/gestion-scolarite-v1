package com.example1.test1_withoutsecurity.bean;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Note implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private Double resultat;
    private String remarque;


    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date_Note;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Matiere matiere;

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

    public Note() {
    }

    public Note(Double resultat, Student student, Date date_Note) {
        this.resultat = resultat;
        this.student = student;
        this.date_Note = date_Note;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDate_Note() {
        return date_Note;
    }

    public void setDate_Note(Date date_Note) {
        this.date_Note = date_Note;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

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

    @Temporal(TemporalType.DATE)
    public Date getDate_note() {
        return date_Note;
    }

    public void setDate_note(Date date_Note) {
        this.date_Note = date_Note;
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

}
