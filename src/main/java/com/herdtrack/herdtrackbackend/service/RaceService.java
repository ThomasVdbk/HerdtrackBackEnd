package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Race;
import com.herdtrack.herdtrackbackend.entity.Vaccin;
import com.herdtrack.herdtrackbackend.repository.RaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RaceService {

    // Injecter le RaceRepo dans le RaceService.
    @Autowired
    private RaceRepo raceRepo;

   /**
     * Trouvez toutes les races dans la base de données et renvoyez-les sous forme de liste.
     *
     * @return Une liste de toutes les races dans la base de données.
     */
     public List<Race> findAll(){
        return this.raceRepo.findAll();
    }
    /**
     * Si la race existe, retournez-la, sinon lancez un 404
     *
     * @param id L'identifiant de la race à trouver
     * @return Un objet facultatif.
     */
    public Race findById(Long id) {
        Optional<Race> optRace = this.raceRepo.findById(id);
        if (optRace.isPresent()) {
            return optRace.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
/**
 * Trouver toutes les races avec la libelle donnée.
 *
 * @param libelle Le nom du paramètre dans la signature de la méthode.
 * @return Une liste de races
 */
public List<Race> findByLibelle(String libelle) {
    return this.raceRepo.findByLibelle(libelle);
}
    /**
     * Créez une nouvelle race et enregistrez-la dans la base de données.
     *
     * @param newRace L'objet Race en cours de création.
     * @return L'objet newRace est renvoyé.
     */
    public Race create(Race newRace) {
        return this.raceRepo.save(newRace);
    }

    /**
     * Si la race existe, mettez-la à jour, sinon lancez une erreur
     *
     * @param race l'objet Race à mettre à jour
     * @return La race mise à jour.
     */
    public Race update(Race race) {
        if (! this.raceRepo.existsById(race.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver le contact a mettre à jour");
        }
        return this.raceRepo.save(race);
    }

    /**
     * Si la race existe, supprimez-la et renvoyez-la, sinon lancez une exception
     *
     * @param id l'id de la race à supprimer
     * @return La race supprimée.
     */
    public Race delete (Long id) {
        if (! this.raceRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver le contact à supprimer");
        }
        Race raceDel = this.findById(id);
        this.raceRepo.deleteById(id);
        if (this.raceRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppression du contact");
        }

        return raceDel;
    }



}
