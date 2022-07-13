package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Medicament;
import com.herdtrack.herdtrackbackend.repository.MedicamentRepo;
import com.herdtrack.herdtrackbackend.service.inter.IMedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentService implements IMedicamentService {

    @Autowired
    private MedicamentRepo medicamentRepo;

    /**
     * methode qui recupere du Repo les medicaments
     *
     * @return List<Medicament>
     * @author Alexandre Dessoly
     */
    @Override
    public List<Medicament> findAll() {
        return this.medicamentRepo.findAll();
    }

    /**
     * methode qui permet de recuperer le medicament par son id
     *
     * @param id Long, id du medicament recherchée
     * @return Medicament
     * @Author Alexandre Dessoly
     */
    @Override
    public Medicament findById(Long id) {
        Optional<Medicament> optMedicament = this.medicamentRepo.findById(id);
        if (optMedicament.isPresent()) {
            return optMedicament.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * methode qui met a jour un medicament dans ma bdd
     *
     * @param newMedicament , le medicament a mettre à jour
     * @return Medicament, le medicament mis à jour
     * @Author Alexandre Dessoly
     */
    @Override
    public Medicament create(Medicament newMedicament) {
        return this.medicamentRepo.save(newMedicament);
    }

    @Override
    public Medicament update(Medicament medicament) {
        if (! this.medicamentRepo.existsById(medicament.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver le medicament a mettre à jour");
        }
        return this.medicamentRepo.save(medicament);
    }

    @Override
    public Medicament delete(Long id) {
        if (! this.medicamentRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver le medicament à supprimer");
        }
        Medicament medicamentDel = this.findById(id);
        this.medicamentRepo.deleteById(id);
        if (this.medicamentRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppression du médicament ");
        }

        return medicamentDel;

    }
}


