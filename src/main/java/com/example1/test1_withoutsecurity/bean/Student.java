package com.example1.test1_withoutsecurity.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/*
 *  Wach save method dkia w 3lach fach tandirha l object deja existant tadir lih duplicate
 *  structure ta3 les beans f had lproject
 *  Auto increment l apoges
 *  Auto increment l date actuel
 *  l9adya ta3 l cle etrangere f un objet ontomany/manytoone ....
 *  wach darori n definiw un constructeur fles class
 *  fin nl9a l configuration ta3 spring security
 */


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // reference
    private String apoge;
    private String cne;
    private String sexe;
    private String name;
    private String lastname;
    private String phone;
    private String mail;
    private String address;
    private String city;
    private String country;
    private Boolean active=true;

    @DateTimeFormat(pattern="yyyy-mm-dd")
    private Date date_Naissanse;

    @ManyToOne(cascade = CascadeType.ALL)              // Verified
    private Filiere filiere;

    @ManyToOne(cascade = CascadeType.ALL)              // Verified
    private Niveau niveau;

    @OneToMany(mappedBy = "student")
    List<Inscription> inscriptions;

    public Student() {
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Student(String apoge, String name, String lastname, String cne, Date date_naissanse) {
        this.apoge = apoge;
        this.name = name;
        this.lastname = lastname;
        this.cne = cne;
        this.date_Naissanse = date_naissanse;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Student(Long id, String code_apoge, String sexe, String cne, String name, String lastname, String phone, String mail, String address, String city, String country, Boolean isActive, Date date_naissanse) {
        this.id = id;
        this.apoge = code_apoge;
        this.sexe = sexe;
        this.cne = cne;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.city = city;
        this.country = country;
        this.date_Naissanse = date_naissanse;
    }


    public void setCne(String cne) {
        this.cne = cne;
    }

//    public Filiere getFiliere() {
//        return filiere;
//    }
//
//    public void setFiliere(Filiere filiere) {
//        this.filiere = filiere;
//    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }


    public String getApoge() {
        return apoge;
    }

    public void setApoge(String apoge) {
        this.apoge = apoge;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    public Date getDate_Naissanse() {
        return date_Naissanse;
    }

    public void setDate_Naissanse(Date date_Naissanse) {
        this.date_Naissanse = date_Naissanse;
    }

    public String getCne() {
        return cne;
    }

    @Override
    public String toString() {
        return "Personne [idPersonne=" + id + ", sexe=" + sexe + ", nom=" + name + ", prenom=" + lastname
                + ", dateDeNaissance=" + date_Naissanse + ", email=" + mail + ", adresse=" + address + ", tel=" + phone
                + " ville=" + city + ", pays=" + country + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
