package com.example.H5220075.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.H5220075.entity.Oyuncak;

@Repository
public interface OyuncakRepository extends JpaRepository<Oyuncak, Long> {

}
