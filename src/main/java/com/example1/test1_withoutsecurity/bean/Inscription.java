package com.example1.test1_withoutsecurity.bean;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@EnableJpaAuditing
@Entity
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @DateTimeFormat(pattern="yyyy-mm-dd")
    private Date date_Inscription;

    @ManyToOne(cascade = CascadeType.ALL)                      // Verified
    private Student student;



    @Temporal(TemporalType.DATE)
    public Date getDate_Inscription() {
        return date_Inscription;
    }

    public void setDate_Inscription(Date date_Inscription) {
        this.date_Inscription = date_Inscription;
    }

    public Inscription() {
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
}

//    public Prof getProf() {
//        return prof;
//    }
//
//    public void setProf(Prof prof) {
//        this.prof = prof;
//    }
//}
