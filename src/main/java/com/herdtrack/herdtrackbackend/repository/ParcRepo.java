package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Parc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcRepo extends JpaRepository<Parc, Long> {
}
