package com.InterviewMertEFE.springbootinterviewproject.service;

import com.InterviewMertEFE.springbootinterviewproject.model.Musteri;
import com.InterviewMertEFE.springbootinterviewproject.repository.MusteriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusteriServiceImp implements MusteriService{

    @Autowired
    private MusteriRepository musteriRepository;

    @Override
    public List<Musteri> getAllMusteri() {
        return musteriRepository.findAll();
    }

    @Override
    public void saveMusteri(Musteri musteri) {
        this.musteriRepository.save(musteri);
    }

    @Override
    public Musteri getMusteriById(long TC) {
        Optional<Musteri> optional = musteriRepository.findById(TC);
        Musteri musteri = null;
        if (optional.isPresent()) {
            musteri = optional.get();
        } else {
            throw new RuntimeException(" TC' kimlik numarasına müşteri bulunamadı." + TC);
        }
        return musteri;
    }

    @Override
    public void deleteMusteriById(long TC) {
        this.musteriRepository.deleteById(TC);

    }

    @Override
    public Musteri FindByKrediskor(int kredi) {
        Musteri musteri = new Musteri();
        if (kredi<1)
        {
            return musteri;
        }
        return musteri;
    }



}
