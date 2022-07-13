package com.herdtrack.herdtrackbackend.repository;

import com.herdtrack.herdtrackbackend.entity.Entree;
import com.herdtrack.herdtrackbackend.entity.Raison;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EntreeRepo extends JpaRepository<Entree, Long> {


    /**
     * Trouvez une entrée par son identifiant et renvoyez-la enveloppée dans un Optional.
     *
     * @param id L'identifiant de l'entité à renvoyer.
     * @return Facultatif<Entrée>
     */
    Optional<Entree> findById(Long id);


    /**
     * Trouver toutes les entrées qui ont été créées à la date donnée.
     *
     * @param date La date de l'entrée
     * @return Une liste d'objets Entrée
     */
    List<Entree> findByDate(Date date);

    List<Entree> findByRaison(Raison raison);

}
