package com.InterviewMertEFE.springbootinterviewproject.model;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Musteri {
    @Id
    @NonNull
    private long TC;
    private String ad;
    private String soyad;
    private int aylikgelir;
    private String telno;
    private int krediskor;
    private int kredilimit;


    public int getKredilimit() {
        return kredilimit;
    }

    public void setKredilimit(int kredilimit) {
        this.kredilimit = kredilimit;
    }

    public Musteri() {
    }

    public long getTC() {
        return TC;
    }

    public void setTC(long TC) {
        this.TC = TC;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getAylikgelir() {
        return aylikgelir;
    }

    public void setAylikgelir(int aylikgelir) {
        this.aylikgelir = aylikgelir;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public int getKrediskor() {
        return krediskor;
    }

    public void setKrediskor(int krediskor) {
        this.krediskor = krediskor;
    }

    @Override
    public String toString() {
        return "Musteri{" +
                "TC=" + TC +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", aylıkgelir=" + aylikgelir +
                ", telno='" + telno + '\'' +
                ", krediskor=" + krediskor +
                '}';
    }
}
