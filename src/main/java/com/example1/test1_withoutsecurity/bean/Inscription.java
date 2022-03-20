package com.example1.test1_withoutsecurity.bean;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.Date;

@EnableJpaAuditing
@Entity
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    @CreatedDate
//    @Temporal(TemporalType.TIMESTAMP)
//    @DateTimeFormat(pattern="yyyy-mm-dd")
//    @Temporal(TemporalType.DATE)

    private Date date_Inscription;

    @ManyToOne(cascade = CascadeType.ALL)                      // Verified
    private Student student;

    public Inscription() {
    }

    public Inscription(Long id, Date date_Inscription, Student student) {
        this.id = id;
        this.date_Inscription = date_Inscription;
        this.student = student;
    }


    public Inscription(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_Inscription() {
        return date_Inscription;
    }

    public void setDate_Inscription(Date date_Inscription) {
        this.date_Inscription = date_Inscription;
    }
}
