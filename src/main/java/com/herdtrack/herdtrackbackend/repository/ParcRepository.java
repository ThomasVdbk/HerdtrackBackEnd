package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Parc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcRepository extends JpaRepository<Parc, Long> {
}
