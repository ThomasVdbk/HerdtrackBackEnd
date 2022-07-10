package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Vaccin;
import com.herdtrack.herdtrackbackend.repository.VaccinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VaccinService {

    // Injecter le VaccinRepo dans le VaccinService.
    @Autowired
    private VaccinRepo vaccinRepo;


   /**
     * > Cette fonction renvoie une liste de tous les vaccins de la base de données
     *
     * @return Une liste de tous les vaccins dans la base de données.
     */
     public List<Vaccin> findAll(){
        return this.vaccinRepo.findAll();
    }
    /**
     * > Si l'option est présente, retourne la valeur, sinon envoie un 404
     *
     * @param id L'identifiant du vaccin à récupérer.
     * @return Un objet de type Vaccin
     */
    public Vaccin findById(Long id) {
        Optional<Vaccin> optVaccin = this.vaccinRepo.findById(id);
        if (optVaccin.isPresent()) {
            return optVaccin.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Trouver tous les objets Vaccin dont le champ libelle correspond à la libelle donnée.
     *
     * @param libelle Nom du champ dans la classe Vaccin.
     * @return Une liste d'objets Vaccin
     */
    public List<Vaccin> findByLibelle(String libelle) {
        return this.vaccinRepo.findByLibelle(libelle);
    }

    /**
     * > Cette fonction retourne une liste de vaccins qui ont le même numéro de lot que celui passé en paramètre
     *
     * @param numero_lot le numéro de lot du vaccin
     * @return Une liste d'objets Vaccin
     */
    public List<Vaccin> findByNumero (String numero_lot){
        return this.vaccinRepo.findByNumero(numero_lot);
    }
    /**
     * > Retrouvez tous les vaccins qui ont été administrés à une date précise
     *
     * @param date La date du vaccin
     * @return Une liste d'objets Vaccin
     */
    public List<Vaccin> findByDate (Date date){
        return this.vaccinRepo.findByDate(date);
    }
    /**
     * > Cette fonction renvoie une liste des vaccins à venir dans les nbrJoursProchain jours à venir
     *
     * @param nbrJoursProchain le nombre de jours avant la prochaine vaccination
     * @return Une liste d'objets Vaccin
     */
    public List<Vaccin> findByDays (int nbrJoursProchain){
        return this.vaccinRepo.findByJours(nbrJoursProchain);
    }
    /**
     * Créez un nouvel objet Vaccin et enregistrez-le dans la base de données.
     *
     * @param newVaccin L'objet Vaccin que nous voulons créer.
     * @return L'objet newVaccin est renvoyé.
     */
    public Vaccin create(Vaccin newVaccin) {
        return this.vaccinRepo.save(newVaccin);
    }

    /**
     * Il met à jour un vaccin dans la base de données
     *
     * @param vaccin l'objet qui sera mis à jour
     * @return Le vaccin mis à jour.
     */
    public Vaccin update(Vaccin vaccin) {
        if (! this.vaccinRepo.existsById(vaccin.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver le vaccin a mettre à jour");
        }
        return this.vaccinRepo.save(vaccin);
    }

    /**
     * Il supprime un vaccin de la base de données
     *
     * @param id l'id du contact à supprimer
     * @return L'objet supprimé
     */
    public Vaccin delete (Long id) {
        if (! this.vaccinRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver le vaccin à supprimer");
        }
        Vaccin vaccinDel = this.findById(id);
        this.vaccinRepo.deleteById(id);
        if (this.vaccinRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppression du vaccin");
        }

        return vaccinDel;
    }



}
