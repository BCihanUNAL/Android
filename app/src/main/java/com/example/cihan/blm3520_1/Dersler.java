package com.example.cihan.blm3520_1;

/**
 * Created by cihan on 26.03.2019.
 */

public class Dersler {
    private String ders;
    private String not;
    private String kisi;
    private float ortalama;

    public Dersler(String s1,String s2,String s3,float ort){
        ders=s1;
        not=s2;
        kisi=s3;
        ortalama=ort;
    }

    public String getDers(){
        return ders;
    }

    public String getNot(){
        return not;
    }

    public String getKisi(){
        return kisi;
    }

    public float getOrt() { return ortalama; }
}
