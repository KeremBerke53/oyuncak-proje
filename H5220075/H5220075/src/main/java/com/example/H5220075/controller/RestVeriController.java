package com.example.H5220075.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.H5220075.dto.OyuncakDTO;
import com.example.H5220075.entity.Oyuncak;
import com.example.H5220075.service.OyuncakServiceImpl;

@RestController
@Slf4j
public class RestVeriController {

    @Autowired
    OyuncakServiceImpl oyuncakService;

    @PostMapping("/ekle")
    public String oyuncakEkle(@RequestBody OyuncakDTO oyuncakDTO) {
        log.info("ekle servisi çağrıldı. Parametreler:" + oyuncakDTO);
        try {
            Oyuncak oyuncak = new Oyuncak();
            log.debug("ekle servisi : Oyuncak nesnesi oluşturuldu");
            oyuncak.setAlisTarihi(oyuncakDTO.getAlisTarihi());
            oyuncak.setAlisFiyati(oyuncakDTO.getAlisFiyati());
            oyuncak.setAd(oyuncakDTO.getAd());
            oyuncak.setTur(oyuncakDTO.getTur());
            oyuncak.setDesi(oyuncakDTO.getDesi());
            oyuncak.setNotlar(oyuncakDTO.getNotlar());
            log.debug("ekle servisi : Oyuncak nesnesinin değerleri atandı.");
            Oyuncak kaydedilmisOyuncak = oyuncakService.oyuncakOlustur(oyuncak);
            log.debug("ekle servisi : Oyuncak servisi çağrıldı.");
            return kaydedilmisOyuncak.getAd() + " adlı oyuncak oluşturuldu.";
        } catch (Exception e) {
            log.error("ekle servisi çalışırken hata aldı. "
                    + "Parametreler:" + oyuncakDTO
                    + "Hata:" + e.getMessage());
        }
        return null;
    }

    @GetMapping("/getir")
    public OyuncakDTO oyuncakGetir(Long id) {
        Oyuncak oyuncak = oyuncakService.oyuncakGetir(id);
        OyuncakDTO oyuncakDTO = new OyuncakDTO(oyuncak.getID(), oyuncak.getAlisTarihi(), oyuncak.getAlisFiyati(), oyuncak.getAd(), oyuncak.getTur(), oyuncak.getDesi(), oyuncak.getNotlar());
        return oyuncakDTO;
    }

    @PutMapping("/guncelle/{id}")
    public OyuncakDTO oyuncakGuncelle(@PathVariable Long id, @RequestBody OyuncakDTO oyuncakDTO) {
        Oyuncak oyuncak = oyuncakService.oyuncakGetir(id);
        oyuncak.setAlisTarihi(oyuncakDTO.getAlisTarihi());
        oyuncak.setAlisFiyati(oyuncakDTO.getAlisFiyati());
        oyuncak.setAd(oyuncakDTO.getAd());
        oyuncak.setTur(oyuncakDTO.getTur());
        oyuncak.setDesi(oyuncakDTO.getDesi());
        oyuncak.setNotlar(oyuncakDTO.getNotlar());
        oyuncakService.oyuncakGuncelle(oyuncak);
        OyuncakDTO oyuncakDTO1 = new OyuncakDTO(oyuncak.getID(), oyuncak.getAlisTarihi(), oyuncak.getAlisFiyati(), oyuncak.getAd(), oyuncak.getTur(), oyuncak.getDesi(), oyuncak.getNotlar());
        return oyuncakDTO1;
    }

    @GetMapping("/index")
    public String index(Model model) {

        model.addAttribute("H5220075", "H5220075");
        model.addAttribute("Kerem Berke", "Öğrenci");
        model.addAttribute("Yılmaztürk", "Soyadı");


        return "index";
    }
}
