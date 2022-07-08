package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Vaccin;
import com.herdtrack.herdtrackbackend.repository.VaccinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VaccinService {

    @Autowired
    private VaccinRepo vaccinRepo;


    public List<Vaccin> findAll(){
        return this.vaccinRepo.findAll();
    }
    public Vaccin findById(Long id) {
        Optional<Vaccin> optVaccin = this.vaccinRepo.findById(id);
        if (optVaccin.isPresent()) {
            return optVaccin.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    public List<Vaccin> findByLibelle(String libelle) {
        return this.vaccinRepo.findByLibelle(libelle);
    }

    public List<Vaccin> findByNumero (String numero_lot){
        return this.vaccinRepo.findByNumero(numero_lot);
    }
    public List<Vaccin> findByDate (Date date){
        return this.vaccinRepo.findByDate(date);
    }
    public List<Vaccin> findByDays (int nbrJoursProchain){
        return this.vaccinRepo.findByDays(nbrJoursProchain);
    }
    public Vaccin create(Vaccin newVaccin) {
        return this.vaccinRepo.save(newVaccin);
    }

    public Vaccin update(Vaccin vaccin) {
        if (! this.vaccinRepo.existsById(vaccin.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver le contact a mettre à jour");
        }
        return this.vaccinRepo.save(vaccin);
    }

    public Vaccin delete (Long id) {
        if (! this.vaccinRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver le contact à supprimer");
        }
        Vaccin vaccinDel = this.findById(id);
        this.vaccinRepo.deleteById(id);
        if (this.vaccinRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppression du contact");
        }

        return vaccinDel;
    }



}
