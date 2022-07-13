package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Traitement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraitementRepo extends JpaRepository<Traitement,Long> {
}
