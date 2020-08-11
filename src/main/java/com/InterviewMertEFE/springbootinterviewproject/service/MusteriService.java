package com.InterviewMertEFE.springbootinterviewproject.service;

import com.InterviewMertEFE.springbootinterviewproject.model.Musteri;
import org.springframework.ui.Model;

import java.util.List;
public interface MusteriService {
    List<Musteri> getAllMusteri();
    void saveMusteri(Musteri musteri);
    Musteri getMusteriById(long TC);
    void deleteMusteriById(long TC);
    Musteri FindByKrediskor(int kredi);
}
