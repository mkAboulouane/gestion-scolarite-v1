package com.example1.test1_withoutsecurity.Dao;

import com.example1.test1_withoutsecurity.bean.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionDao extends JpaRepository<Inscription,Long> {
}
