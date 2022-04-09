package com.example1.test1_withoutsecurity.Dao;

import com.example1.test1_withoutsecurity.bean.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionDao extends JpaRepository<Inscription, Long> {

    @Query("select inscription from Inscription inscription where inscription.student.apoge=:apoges")
    public Inscription findByInscription(@Param("apoges") String apoges);


}
