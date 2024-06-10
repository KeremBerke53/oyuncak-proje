package com.example.H5220075.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.H5220075.entity.Oyuncak;
import com.example.H5220075.repo.OyuncakRepository;

import java.util.List;

@Service
@Slf4j
public class OyuncakServiceImpl implements OyuncakService {

    @Autowired
    OyuncakRepository oyuncakRepo;

    @Override
    public Oyuncak oyuncakGetir(Long id) {
        log.info("oyuncakGetir servisi çağrıldı.");
        return oyuncakRepo.findById(id).orElse(null);
    }

    @Override
    public Oyuncak oyuncakOlustur(Oyuncak oyuncak) {
        return oyuncakRepo.save(oyuncak);
    }

    @Override
    public List<Oyuncak> oyuncaklariListele() {
        return oyuncakRepo.findAll();
    }

    @Override
    public Oyuncak oyuncakGuncelle(Oyuncak oyuncak) {
        return oyuncakRepo.save(oyuncak);
    }

    @Override
    public void oyuncakSil(Long id) {
        oyuncakRepo.deleteById(id);
    }
}
