package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Entree;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EntreeRepo extends JpaRepository<Entree, Long> {


    Optional<Entree> findById(Long id);

    List<Entree> findByDate(Date date);


}
