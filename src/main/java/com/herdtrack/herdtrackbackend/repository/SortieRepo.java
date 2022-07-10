package com.herdtrack.herdtrackbackend.repository;


import com.herdtrack.herdtrackbackend.entity.Sortie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SortieRepo extends JpaRepository<Sortie, Long> {


    Optional<Sortie> findById(Long id);

    List<Sortie> findByDate(Date date);


}
