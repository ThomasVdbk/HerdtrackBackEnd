package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepo extends JpaRepository<Medicament,Long> {

}
