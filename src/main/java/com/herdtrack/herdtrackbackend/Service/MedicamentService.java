package com.herdtrack.herdtrackbackend.Service;

import com.herdtrack.herdtrackbackend.Entity.CarnetSanitaire;
import com.herdtrack.herdtrackbackend.Entity.Medicament;
import com.herdtrack.herdtrackbackend.repository.MedicamentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentService {

    @Autowired
    private MedicamentRepo medicamentRepo;

    /**
     * methode qui recupere du Repo les medicaments
     *
     * @return List<Medicament>
     * @author Alexandre Dessoly
     */
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
    public Medicament create(Medicament newMedicament) {
        return this.medicamentRepo.save(newMedicament);
    }

    public Medicament update(Medicament medicament) {
        if (! this.medicamentRepo.existsById(medicament.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver le medicament a mettre à jour");
        }
        return this.medicamentRepo.save(medicament);
    }

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


