package com.InterviewMertEFE.springbootinterviewproject.repository;

import com.InterviewMertEFE.springbootinterviewproject.model.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusteriRepository extends JpaRepository<Musteri,Long> {
    String findByKrediskor(int kredi);

}
