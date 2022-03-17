package com.example1.test1_withoutsecurity.Dao;

import com.example1.test1_withoutsecurity.bean.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NiveauDao extends JpaRepository<Niveau, Long> {
    public Niveau findBySemestre(String semestre);

    public List<Niveau> findAll();
//    int deleteBySemestre(String semetre);
}
