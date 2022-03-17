package com.example1.test1_withoutsecurity.Dao;

import com.example1.test1_withoutsecurity.bean.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliereDao extends JpaRepository<Filiere, Long> {

    @Query("select filiere from Filiere filiere where filiere.nomfiliere=:nom_fil")
    public Filiere findByNom_Filiere(@Param("nom_fil") String nom_fil);

}
