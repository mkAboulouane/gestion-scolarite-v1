package com.example1.test1_withoutsecurity.bean;
import javax.persistence.*;

@Entity
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name_Matiere;

    @ManyToOne                          // Verified
    private Filiere filiere;


    @ManyToOne                          // New
    private Niveau niveau;



    @OneToOne
    private Prof prof;

    @ManyToOne
    private Departement departement;


    @OneToOne(mappedBy = "matiere")    // Verified
    private Note note;

    @OneToOne(mappedBy = "matiere")    // Verified
    private Absence absence;


    public void setId_Matiere(Long id) {
        this.id = id;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Absence getAbsence() {
        return absence;
    }

    public void setAbsence(Absence absence) {
        this.absence = absence;
    }



    public Matiere(Long id, String name_matiere, Filiere filiere) {
        this.id = id;
        this.name_Matiere = name_matiere;
        this.filiere = filiere;
    }

    public Matiere() {
    }
    public Long getId_Matiere() {
        return id;
    }

    public String getName_matiere() {
        return name_Matiere;
    }

    public void setName_matiere(String name_matiere) {
        this.name_Matiere = name_Matiere;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
}
