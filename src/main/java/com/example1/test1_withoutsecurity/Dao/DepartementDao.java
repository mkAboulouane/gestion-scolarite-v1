package com.example1.test1_withoutsecurity.Dao;

import com.example1.test1_withoutsecurity.bean.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype .Repository;

@Repository
public interface DepartementDao extends JpaRepository<Departement,Long> {
    @Query("select departement from Departement departement where departement.nom_Depart=:nom_depart")
    Departement findByNomDepartement(@Param("nom_depart") String nom_depart);


}
