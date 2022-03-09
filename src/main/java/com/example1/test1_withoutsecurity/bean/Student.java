package com.example1.test1_withoutsecurity.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
//

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Student;
    // not entred
    @JoinColumn(name = "code_apoge", nullable = false, updatable = false,unique = true)
    private String apoge = "E" + id_Student;
    @JoinColumn(name = "cne", nullable = false,unique = true)
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
    private Date date_naissanse;

    @ManyToOne(cascade = CascadeType.ALL)              // Verified
    @JoinColumn(name = "filiere_id",nullable = false)
    private Filiere filiere;

    @ManyToOne(cascade = CascadeType.ALL)              // Verified
    @JoinColumn(name = "niveau_id",nullable = false)              // Verified
    private Niveau niveau;

    @JsonIgnore
    @OneToOne(mappedBy = "student")     // Verified
    private Inscription inscription;

    @JsonIgnore
    @OneToMany(mappedBy = "student")  //(mappedBy = "student")     // Verified
    private List<Note> notes;

    @JsonIgnore
    @OneToMany(mappedBy = "student")    // Verified
    private List<Absence> absence;

    public Student() {
    }

    public Student(String apoge, String name, String lastname, Boolean isactive, String cne, Date date_naissanse) {
        this.apoge = apoge;
        this.name = name;
        this.lastname = lastname;
        this.cne = cne;
        this.active = active;
        this.date_naissanse = date_naissanse;
    }

    public Student(Long id, String code_apoge, String sexe, String cne, String name, String lastnam, String phone, String mail, String address, String city, String country, Boolean isActive, Date date_naissanse) {
        this.id_Student = id;
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
        this.active = active;
        this.date_naissanse = date_naissanse;
    }



    public Long getId_Student() {
        return id_Student;
    }

//    public void setId_Inscription(Long id_Student) {

    public void setId_Student(Long id_Student) {
        this.id_Student = id_Student;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public Filiere getFiliere() {
        return filiere;
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

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<Absence> getAbsence() {
        return absence;
    }

    public void setAbsence(List<Absence> absence) {
        this.absence = absence;
    }

    @Column(name = "code_apoge", unique = true, nullable = false, length = 45)
    public String getApoge() {
        return apoge;
    }

    public void setApoge(String apoge) {
        this.apoge = apoge;
    }

    @Column(name = "sexe", unique = false, length = 10)
    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @Column(name = "name", unique = false, nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "lastname", unique = false, nullable = false, length = 45)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "phone", unique = true, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "mail", unique = true, length = 45)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Column(name = "name", length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "city", length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "country", length = 45)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "status", length = 45)
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        active = active;
    }

    @Column(name = "naissanse", length = 45)
    public Date getDate_naissanse() {
        return date_naissanse;
    }

    public void setDate_naissanse(Date date_naissanse) {
        this.date_naissanse = date_naissanse;
    }

    @Column(name = "cne", length = 45, unique = true, nullable = false)
    public String getCne() {
        return cne;
    }

    @Override
    public String toString() {
        return "Personne [idPersonne=" + id_Student + ", sexe=" + sexe + ", nom=" + name + ", prenom=" + lastname
                + ", dateDeNaissance=" + date_naissanse + ", email=" + mail + ", adresse=" + address + ", tel=" + phone
                + " ville=" + city + ", pays=" + country + "]";
    }
}
