package com.herdtrack.herdtrackbackend.service.inter;

import com.herdtrack.herdtrackbackend.entity.Medicament;

import java.util.List;

public interface IMedicamentService {
    List<Medicament> findAll();

    Medicament findById(Long id);

    Medicament create(Medicament newMedicament);

    Medicament update(Medicament medicament);

    Medicament delete(Long id);
}
