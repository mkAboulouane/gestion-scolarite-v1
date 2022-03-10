package com.example1.test1_withoutsecurity.Dao;

import com.example1.test1_withoutsecurity.bean.Departement;
import com.example1.test1_withoutsecurity.bean.Prof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfDao extends JpaRepository<Prof , Long> {

    public Prof findByCin (String cin );

    @Query("SELECT p FROM Prof p WHERE p.departement.nom_Depart =: nom_dep")
    public List<Prof> findByDepartProf (@Param("nom_dep") String nom_dep);

    @Query("select prof from Prof prof where prof.matricule=:matr")
    public Prof findByMatricule(@Param("matr") String matr);

}
