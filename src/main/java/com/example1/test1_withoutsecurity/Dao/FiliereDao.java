package com.example1.test1_withoutsecurity.Dao;

import com.example1.test1_withoutsecurity.bean.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliereDao extends JpaRepository<Filiere,Long> {
       // public Filiere findById_filiere(Long id);
}
