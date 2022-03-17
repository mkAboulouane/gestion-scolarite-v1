package com.example1.test1_withoutsecurity.Dao;

import com.example1.test1_withoutsecurity.bean.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SeanceDao extends JpaRepository<Seance, Long> {
    Seance findByReference(String reference);

    @Query("select max(seance.id) from Seance seance")
    public Long SeanceReferenceIncrement();

    @Query("select seance from Seance seance  where seance.date_Seance=:date")
    public List<Seance> findSeanceInDate(@Param("date") Date date);

    /*
Chercher les Seances avec le meme date et la meme salle
 */

    @Query("select seance from Seance seance  where seance.salle=:salle")
    public List<Seance> findSeanceInSalle(@Param("salle") String salle);


    @Query("select seance from Seance seance where seance.date_Seance=:date and seance.salle=:salle1 and seance.heure=:heure")
    public Seance findByDateAndSalle(@Param("date") Date date, @Param("salle1") String salle1, @Param("heure") int heure);

//    List<Seance> findByDate(Date date_Seance);

}
