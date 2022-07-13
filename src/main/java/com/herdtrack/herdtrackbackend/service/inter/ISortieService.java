package com.herdtrack.herdtrackbackend.service.inter;

import com.herdtrack.herdtrackbackend.entity.Raison;
import com.herdtrack.herdtrackbackend.entity.Sortie;

import java.util.Date;
import java.util.List;

public interface ISortieService {
    List<Sortie> findAll();

    Sortie findById(Long id);

    List<Sortie> findByDate(Date date);

    List<Sortie> findByRaison(Raison raison);

    Sortie create(Sortie newSortie);

    Sortie update(Sortie sortie);

    Sortie delete(Long id);
}
