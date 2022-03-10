package com.example1.test1_withoutsecurity.Dao;

import com.example1.test1_withoutsecurity.bean.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface NoteDao extends JpaRepository<Note, Long> {
    List<Note> findByResultat(double resultat);

    @Query("select note from Note note where note.reference=:reference")
    Note findByReference(@Param("reference") String reference);

    @Query("select note from Note note where note.resultat<5 and note.matiere.name_Matiere=:mat")
    List<Note> findByNv(@Param("mat") String mat);

    @Query("select note from Note note where note.resultat>5 and note.resultat<10 and note.matiere.name_Matiere=:mat")
    List<Note> findByRatt(@Param("mat") String mat);

    @Query("select note from Note note where note.resultat>10 and note.matiere.name_Matiere=:mat")
    List<Note> findByVM(@Param("mat") String mat);
}
