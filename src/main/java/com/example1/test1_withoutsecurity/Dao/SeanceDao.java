package com.example1.test1_withoutsecurity.Dao;

import com.example1.test1_withoutsecurity.bean.Absence;
import com.example1.test1_withoutsecurity.bean.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface SeanceDao extends JpaRepository<Seance,Long> {
    Seance findByReference(String reference);
    List<Seance> findByDate(Date date_Seance);
}
