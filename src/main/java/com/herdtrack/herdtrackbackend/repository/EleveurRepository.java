package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Eleveur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EleveurRepository extends JpaRepository<Eleveur, Long> {
}
