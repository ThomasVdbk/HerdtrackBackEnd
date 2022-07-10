package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.Entity.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepo extends JpaRepository<Medicament,Long> {
    
}
