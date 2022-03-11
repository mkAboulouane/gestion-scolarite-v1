package com.example1.test1_withoutsecurity.Dao;

import com.example1.test1_withoutsecurity.bean.Resultat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultatDao extends JpaRepository<Resultat,Long> {

    @Query("select note.resultat from Note note where note.student.apoge=:apoges and note.matiere.name_Matiere=:matiere")
    public List<Double> getResultatByMatiere(@Param("apoges") String apoges,@Param("matiere") String matiere);

}
