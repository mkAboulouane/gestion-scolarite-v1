package com.example1.test1_withoutsecurity.Dao;

import com.example1.test1_withoutsecurity.bean.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereDao extends JpaRepository<Matiere,Long> {
    @Query("select matiere from Matiere matiere where matiere.name_Matiere=:nom")
    public Matiere findByMatiereNom(@Param("nom") String nom);



}
