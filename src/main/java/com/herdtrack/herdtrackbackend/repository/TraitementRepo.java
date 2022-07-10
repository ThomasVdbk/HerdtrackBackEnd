package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.Entity.Traitement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraitementRepo extends JpaRepository<Traitement,Long> {
}
