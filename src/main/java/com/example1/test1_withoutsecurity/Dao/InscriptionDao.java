package com.example1.test1_withoutsecurity.Dao;

import com.example1.test1_withoutsecurity.bean.Inscription;
import com.example1.test1_withoutsecurity.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionDao extends JpaRepository<Inscription,Long> {
    @Query("select s from Inscription s where s.student=:x ")
    public List<Inscription> findByStudent(@Param("x") Student student);
}
