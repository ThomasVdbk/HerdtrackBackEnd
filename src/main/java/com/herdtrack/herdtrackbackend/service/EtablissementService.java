package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.entity.Etablissement;
import com.herdtrack.herdtrackbackend.repository.EtablissementRepo;
import com.herdtrack.herdtrackbackend.service.inter.IEtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EtablissementService implements IEtablissementService {

    @Autowired
    private EtablissementRepo etablissementRepo;

    /*
    methode qui retourne la liste de l'ensemble des etablissements
    @return Etablissement List
    @author Nicolas Desdevises
    */
    @Override
    public List<Etablissement> findAll() {

        return etablissementRepo.findAll();
    }

    /*
     methode qui recupere un etablissment en fonction de son id
     @param id Long, id de l'etablissement recherché
     @return Etablissement
     @author Nicolas Desdevises
     */
    @Override
    public Etablissement findById(Long id) {

        Optional<Etablissement> optEtablissement = this.etablissementRepo.findById(id);
        if (optEtablissement.isPresent()) {
            return optEtablissement.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /*
     methode qui recupere une liste d'etablissment en fonction de son NumeroExploitation
     @param  numeroExploitation String, numeroExploitation de l'etablissement recherché
     @return Etablissement
     @author Nicolas Desdevises
     */
    @Override
    public Etablissement findByNumeroExploitation(String numeroExploitation) {

        return etablissementRepo.findByNumeroExploitation(numeroExploitation);

    }

    /*
     methode pour créer un établissment
     @param etablissement Etablissement, etablissement à enregistrer
     @return Etablissement créé
     @author Nicolas Desdevises
     */
    @Override
    public Etablissement create(Etablissement etablissement) {

        return this.etablissementRepo.save(etablissement);
    }

    /*
     methode pour mettre à jour un établissment
     @param etablissement Etablissement, etablissement qui contient la mise à jour
     @return Etablissement mise à jour
     @author Nicolas Desdevises
     */
    @Override
    public Etablissement update(Etablissement etablissement) {

        if (!this.etablissementRepo.existsById(etablissement.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver l'etablissement a mettre à jour");
        }

        return this.etablissementRepo.save(etablissement);
    }
}
