package com.example1.test1_withoutsecurity.bean;
import javax.persistence.*;

@Entity
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // reference
    private String name_Matiere;

    @ManyToOne                          // Verified
    private Filiere filiere;

    @ManyToOne                          // New
    private Niveau niveau;



    @ManyToOne
    private Departement departement;

    public Filiere getFiliere() {
        return filiere;
    }

    public Matiere(Long id, String name_Matiere, Filiere filiere, Niveau niveau, Departement departement) {
        this.id = id;
        this.name_Matiere = name_Matiere;
        this.filiere = filiere;
        this.niveau = niveau;
        this.departement = departement;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public void setId_Matiere(Long id) {
        this.id = id;
    }


    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Matiere() {
    }

    public String getName_Matiere() {
        return name_Matiere;
    }

    public void setName_Matiere(String name_Matiere) {
        this.name_Matiere = name_Matiere;
    }

    public void setName_matiere(String name_matiere) {
        this.name_Matiere = name_Matiere;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
