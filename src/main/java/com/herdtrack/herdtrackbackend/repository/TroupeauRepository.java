package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Troupeau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TroupeauRepository extends JpaRepository<Troupeau, Long> {
}
