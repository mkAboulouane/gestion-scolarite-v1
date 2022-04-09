package com.example1.test1_withoutsecurity.Dao;

import com.example1.test1_withoutsecurity.bean.Prof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfDao extends JpaRepository<Prof, Long> {

    Prof findByCin(String cin);

    @Query("SELECT p FROM Prof p WHERE p.departement.nom_Depart =: nom_dep")
    List<Prof> findByDepartProf(@Param("nom_dep") String nom_dep);

    @Query("select prof from Prof prof where prof.matricule=:matr")
    Prof findByMatricule(@Param("matr") String matr);

    @Query("select prof from Prof prof where prof.email=:email")
    Prof findByEmail(@Param("email") String email);


}
