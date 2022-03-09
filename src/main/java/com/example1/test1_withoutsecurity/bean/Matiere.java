package com.example1.test1_withoutsecurity.bean;
import javax.persistence.*;

@Entity
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_matiere;
    @JoinColumn(name = "matiere", nullable = false, updatable = false)
    private String name_matiere;

    @ManyToOne                          // Verified
    @JoinColumn(name="filliere_id",nullable = false)
    private Filiere filiere;


    @ManyToOne                          // New
    @JoinColumn(name="niveau_id",nullable = false)
    private Niveau niveau;



    @OneToOne
    @JoinColumn(name = "prof_id",nullable = false)      // Verified
    private Prof prof;

    @ManyToOne
    @JoinColumn(name="departement_id",nullable = false)  // Verified
    private Departement departement;


    @OneToOne(mappedBy = "matiere")    // Verified
    private Note note;

    @OneToOne(mappedBy = "matiere")    // Verified
    private Absence absence;





    public void setId_matiere(Long id_matiere) {
        this.id_matiere = id_matiere;
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



    public Matiere(Long id_matiere, String name_matiere, Filiere filiere) {
        this.id_matiere = id_matiere;
        this.name_matiere = name_matiere;
        this.filiere = filiere;
    }

    public Matiere() {
    }


    public Long getId_matiere() {
        return id_matiere;
    }

    public String getName_matiere() {
        return name_matiere;
    }

    public void setName_matiere(String name_matiere) {
        this.name_matiere = name_matiere;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
}
