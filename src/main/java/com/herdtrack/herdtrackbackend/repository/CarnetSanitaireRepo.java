package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.Entity.CarnetSanitaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarnetSanitaireRepo extends JpaRepository<CarnetSanitaire,Long> {
}
