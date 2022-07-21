package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Eleveur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EleveurRepo extends JpaRepository<Eleveur, Long> {
}
