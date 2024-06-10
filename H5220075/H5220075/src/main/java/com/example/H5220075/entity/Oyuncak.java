package com.example.H5220075.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Oyuncak {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private Date alisTarihi;
    private Double alisFiyati;
    private String ad;
    private String tur;
    private Integer desi;
    private String notlar;
}
