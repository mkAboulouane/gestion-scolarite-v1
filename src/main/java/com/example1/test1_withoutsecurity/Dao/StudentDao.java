package com.example1.test1_withoutsecurity.Dao;

import com.example1.test1_withoutsecurity.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
    public List<Student> findAll();

    public Student findByApoge(String apoge);

    @Query("SELECT student from Student student where student.niveau.id_Niveau=:id_niveau and student.filiere.id=:id_fil")
    public List<Student> findSameNiveauAndFilliere(@Param("id_niveau") Long id_niveau,@Param("id_fil") Long id_fil);

    @Query("SELECT student from Student student where student.niveau.id_Niveau=:id_niveau")
    public List<Student> findSameNiveau(@Param("id_niveau") Long id_niveau);

    @Query("SELECT student from Student student where student.filiere.id=:id_fil")
    public List<Student> findSameFilliere(@Param("id_fil") Long id_fil);

    public void deleteByApoge(String apoge);

    Student findByCne(String cne);
}
