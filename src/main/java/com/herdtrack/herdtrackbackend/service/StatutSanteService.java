package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.StatutSante;
import com.herdtrack.herdtrackbackend.repository.StatutSanteRepo;
import com.herdtrack.herdtrackbackend.service.inter.IStatutSanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StatutSanteService implements IStatutSanteService {

    @Autowired
    private StatutSanteRepo statutSanteRepository;

    /*
    methode qui retourne la liste de l'ensemble des StatutSante
    @return StatutSante List
    @author Nicolas Desdevises
    */
    public List<StatutSante> findAll() {
        return statutSanteRepository.findAll();
    }

    /*
    methode qui recupere un statutSante en fonction de son id
    @param id Long, id du statutSante recherché
    @return StatutSante
    @author Nicolas Desdevises
    */
    @Override
    public StatutSante findById(Long id) {

        Optional<StatutSante> optStatutSante = this.statutSanteRepository.findById(id);
        if (optStatutSante.isPresent()) {
            return optStatutSante.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /*
    methode pour créer un statutSante.
    @param parc StatutSante, parc à enregistrer
    @return StatutSante créé
    @author Nicolas Desdevises
    */
    @Override
    public StatutSante create(StatutSante statutSante) {

        return this.statutSanteRepository.save(statutSante);
    }

    /*
    methode pour mettre à jour un statutSante
    @param statutSante StatutSante, statutSante qui contient la mise à jour
    @return StatutSante mise à jour
    @author Nicolas Desdevises
    */
    @Override
    public StatutSante update(StatutSante statutSante) {

        if (!this.statutSanteRepository.existsById(statutSante.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver le parc a mettre à jour");
        }

        return this.statutSanteRepository.save(statutSante);
    }
}
