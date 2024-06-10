package com.example.H5220075.service;

import com.example.H5220075.entity.Oyuncak;
import java.util.List;

public interface OyuncakService {

    Oyuncak oyuncakGetir(Long id);

    Oyuncak oyuncakOlustur(Oyuncak oyuncak);

    List<Oyuncak> oyuncaklariListele();

    Oyuncak oyuncakGuncelle(Oyuncak oyuncak);

    void oyuncakSil(Long id);
}

