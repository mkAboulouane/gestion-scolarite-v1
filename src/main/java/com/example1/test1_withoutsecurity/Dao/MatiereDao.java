package com.example1.test1_withoutsecurity.Dao;

import com.example1.test1_withoutsecurity.bean.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatiereDao extends JpaRepository<Matiere, Long> {

    @Query("select matiere from Matiere matiere where matiere.name_Matiere=:nom")
    public Matiere findByMatiereNom(@Param("nom") String nom);


    @Query("select matiere.name_Matiere from Matiere matiere where matiere.filiere.nomfiliere=:nom_fil and matiere.niveau.semestre=:nom_semestre")
    public List<String> findMatiereInFiliereAndNiveau(@Param("nom_fil") String nom_fil, @Param("nom_semestre") String nom_semestre);


}
