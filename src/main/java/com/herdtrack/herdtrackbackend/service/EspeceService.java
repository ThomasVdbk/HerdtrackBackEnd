package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Espece;
import com.herdtrack.herdtrackbackend.entity.Race;
import com.herdtrack.herdtrackbackend.repository.EspeceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class EspeceService {
    @Autowired
    private EspeceRepo especeRepo;


    // Une méthode qui est utilisée pour trouver toutes les espèces dans la base de données.
    public List<Espece> findAll(){
        return this.especeRepo.findAll();
    }

    /**
     * Si l'option est présente, retournez la valeur, sinon lancez un 404
     *
     * @param id l'identifiant de l'espèce à trouver
     * @return La méthode renvoie un objet Espece.
     */
    public Espece findById(Long id) {
        Optional<Espece> optEspece = this.especeRepo.findById(id);
        if (optEspece.isPresent()) {
            return optEspece.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrouvez toutes les espèces dont le nom est 'libelle'
     *
     * @param libelle Le nom du paramètre dans la signature de la méthode.
     * @return Une liste d'objets Espece
     */
    public List<Espece> findByLibelle(String libelle) {
        return this.especeRepo.findByLibelle(libelle);
    }

    /**
     * Il crée une nouvelle espèce dans la base de données
     *
     * @param newEspece Le nouvel objet Espece que nous voulons créer.
     * @return L'objet newEspece est renvoyé.
     */
    public Espece create(Espece newEspece) {
        return this.especeRepo.save(newEspece);
    }
    /**
     * Il met à jour une espèce existante dans la base de données
     *
     * @param espece l'objet à mettre à jour
     * @return L'espece mis à jour.
     */
    public Espece update(Espece espece) {
        if (! this.especeRepo.existsById(espece.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver l'espèce a mettre à jour");
        }
        return this.especeRepo.save(espece);
    }
    /**
     * Il supprime une espèce de la base de données
     *
     * @param id l'identifiant de l'espèce à supprimer
     * @return L'objet Espece supprimé.
     */
    public Espece delete (Long id) {
        if (! this.especeRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'espèce à supprimer");
        }
        Espece especeDel = this.findById(id);
        this.especeRepo.deleteById(id);
        if (this.especeRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppression de l'espèce");
        }

        return especeDel;
    }

    public List<Race> findEspeceById(Long id){
       return this.especeRepo.findEspeceById(id);
    }
}
