package com.example1.test1_withoutsecurity.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Result")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Note;
    //private String note_reference = "N" + id_Note;
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
    @JoinColumn(name = "student_id")     // Verified
    private Student student;


    @OneToOne// Verified
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    @JoinColumn(name = "Id", nullable = false)
    public Long getId_Note() {
        return id_Note;
    }

    public void setId_Note(Long id_Note) {
        this.id_Note = id_Note;
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

//    public String getNote_reference() {
//        return note_reference;
//    }
//
//    public void setNote_reference(String note_reference) {
//        this.note_reference = note_reference;
//    }

}
