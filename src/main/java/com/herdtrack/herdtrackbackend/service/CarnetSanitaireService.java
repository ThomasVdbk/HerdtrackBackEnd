package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.CarnetSanitaire;
import com.herdtrack.herdtrackbackend.repository.CarnetSanitaireRepo;
import com.herdtrack.herdtrackbackend.service.inter.ICarnetSanitaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CarnetSanitaireService implements ICarnetSanitaireService {

    @Autowired
    private CarnetSanitaireRepo carnetSanitaireRepo;

    /**
     * methode qui recupere du Repo les carnets sanitaire
     * @return List<CarnetSanitaire>
     * @author Alexandre Dessoly
     */
    @Override
    public List<CarnetSanitaire> findAll() {
        return this.carnetSanitaireRepo.findAll();
    }

    /**
     * methode qui permet de recuperer le carnet sanitaire par son id
     * @param id Long, id du carnet sanitaire recherchée
     * @return Carnet Sanitaire
     * @Author Alexandre Dessoly
     */
    @Override
    public CarnetSanitaire findById(Long id) {
        Optional<CarnetSanitaire> optCarnetSanit = this.carnetSanitaireRepo.findById(id);
        if (optCarnetSanit.isPresent()) {
            return optCarnetSanit.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * methode qui permet d'enregistrer un Carnet sanitaire
     * @param newCarnetSanit a enregistrée
     * @return CarnetSanitaire, le carnet sanitaire est enregistré avec son id
     * @Author Alexandre Dessoly
     */
    @Override
    public CarnetSanitaire create(CarnetSanitaire newCarnetSanit) {
            return this.carnetSanitaireRepo.save(newCarnetSanit);
        }

    /**
     * methode qui met a jour un carnet sanitaire dans ma bdd
     * @param carnetSanitaire , le carnet sanitaire a mettre à jour
     * @return CarnetSanitarie, le carnet  sanitaire mis à jour
     * @Author Alexandre Dessoly
     */
    @Override
    public CarnetSanitaire update(CarnetSanitaire carnetSanitaire) {
            if (! this.carnetSanitaireRepo.existsById(carnetSanitaire.getId())) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                        "impossible de trouver le carnet sanitaire a mettre à jour");
            }
            return this.carnetSanitaireRepo.save(carnetSanitaire);
        }

    @Override
    public CarnetSanitaire delete(Long id) {
            if (! this.carnetSanitaireRepo.existsById(id)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "impossible de trouver le carnet sanitaire à supprimer");
            }
            CarnetSanitaire carnetSanitDel = this.findById(id);
            this.carnetSanitaireRepo.deleteById(id);
            if (this.carnetSanitaireRepo.existsById(id)) {
                throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                        "erreur lors de la suppression du carnet sanitaire");
            }

            return carnetSanitDel;

        }
}


