package com.example1.test1_withoutsecurity.Dao;

import com.example1.test1_withoutsecurity.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {

    public Student findByApoge(String apoge);

    @Query("SELECT student from Student student where student.niveau.semestre=:semstre and student.filiere.nomfiliere=:nom_Fil")
    public List<Student> findSameNiveauAndFilliere(@Param("semstre") String semstre, @Param("nom_Fil") String nom_Fil);

    @Query("SELECT student from Student student where student.niveau.semestre=:semstre")
    public List<Student> findSameNiveau(@Param("semstre") String semstre);

    @Query("SELECT student from Student student where student.filiere.nomfiliere=:nom_Fil")
    public List<Student> findSameFilliere(@Param("nom_Fil") String nom_Fil);

    @Query("select max(student.id) from Student student")
    public Long CodeApogeIncrement();

    Student findByCne(String cne);
}
